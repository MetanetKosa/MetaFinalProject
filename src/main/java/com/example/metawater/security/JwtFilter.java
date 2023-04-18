package com.example.metawater.security;


import com.example.metawater.domain.MemberDTO;
import com.example.metawater.domain.MemberVO;
import com.example.metawater.mapper.MemberMapper;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

//Filter로 로그인 한 사람/안한 사람 권한 부여
public class JwtFilter extends BasicAuthenticationFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MemberMapper memberMapper;
//    private ManagerMapper managerMapper;


    public JwtFilter(AuthenticationManager authenticationManager, MemberMapper memberMapper) {
        super(authenticationManager);
        this.memberMapper = memberMapper;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request2, HttpServletResponse response2,
                                    FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) request2;
        HttpServletResponse response = (HttpServletResponse) response2;

        System.out.println(request.getHeader("AUTHORIZATION"));
        if (request.getHeader("AUTHORIZATION") == null) {
            logger.info("AUTHORIZATION 로그인 안 한 사람");
            onError(response, "UNAUTHORIZATION");
            return;
        } else {
            String authorizationHeader = request.getHeader("AUTHORIZATION");
            System.out.println("AUTHORIZATION : " + authorizationHeader);
            String jwt = authorizationHeader.replace("Bearer", "");
            if (!isJwtValid(jwt)) {
                logger.info("!isJwtValid 토큰 없는거 같은데?");
                onError(response, "UNAUTHORIZATION");
                return;
            }
            String name = Jwts.parser().setSigningKey("hello").parseClaimsJws(jwt).getBody().getSubject();
            MemberVO memberVO = memberMapper.findByUserId(name);
//            ManagerDTO managerDTO = managerMapper.managerGetUserByIdAndPassword(name);
            if (memberVO != null) {
                logger.info("-------------------- 회원 -------------------------");
                UserDetails user = User.builder()
                        .username(memberVO.getMemId())
                        .password(memberVO.getMemPw()) //TODO: 여기서 Auth(회원/관리자) 구분
                        .authorities(memberVO.getRoles())
//                        .authorities(memberVO.getRoles().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())))
                        .build();

                Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority(memberVO.getRoles()));

                Authentication authentication = new UsernamePasswordAuthenticationToken(
                       user,
                       memberVO.getMemPw(),
                        authorities
//                        memberVO.getRoles().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList())
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
                logger.info("-------authentication 값 확인--------" + authentication);
                System.out.println("authentication 값 확인" + authentication);
                if (authentication != null && authentication.isAuthenticated() && authentication.getAuthorities().stream()
                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_USER"))) {
                    filterChain.doFilter(request, response);
                }
                else {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                }
                filterChain.doFilter(request2, response2);
            }
//            else if (managerDTO != null) {
//                System.out.println("-------------------- 관리자 -------------------------");
//                UserDetails user = User.builder()
//                        .username(managerDTO.getId())
//                        .password(managerDTO.getPassword())
//                        .authorities(managerDTO.getRoles().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
//                                .collect(Collectors.toList()))
//                        .build();
//                Authentication authentication = new UsernamePasswordAuthenticationToken(
//                        user,
//                        managerDTO.getPassword(),
//                        managerDTO.getRoles().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
//                                .collect(Collectors.toList()));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//                System.out.println("authenticationauthenticationauthenticationauthentication" + authentication);
//                if (authentication != null && authentication.isAuthenticated() && authentication.getAuthorities().stream()
//                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_MANAGER"))) {
//                    filterChain.doFilter(request, response);
//                }
//                else {
////                    System.out.println("430430430430430430430430430403403403403403403403403403");
//                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//                }
//                filterChain.doFilter(request2, response2);
//            }
            else {
                throw new UsernameNotFoundException("사용자 없음 UsernameNotFoundException");
            }
        }
    }

    public boolean isJwtValid(String jwt) {
        boolean returnValue = true;
        String token = null;
        try {
            token = Jwts.parser().setSigningKey("hello").parseClaimsJws(jwt).getBody().getSubject();
            logger.info("token 생성 : " + token);
            System.out.println("token 생성 : " + token);
        }catch (Exception e){
            returnValue=false;
        }
        if(token==null || token.isEmpty()){
            returnValue = false;
        }
        return returnValue;
    }

    private void onError(HttpServletResponse response, String httpStatus) throws IOException{
        response.addHeader("error", httpStatus);
        response.sendError(HttpServletResponse.SC_FORBIDDEN,httpStatus);
    }
}

