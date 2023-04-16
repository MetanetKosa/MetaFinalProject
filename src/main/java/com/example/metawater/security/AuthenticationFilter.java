//package com.example.metawater.security;
//
//import com.example.metawater.domain.MemberVO;
//import com.example.metawater.service.MemberService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.core.env.Environment;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//
////스프링 시큐리티 필터의 주요 역할이 인증 관련된 정보를 토큰이라는 객체로 만들어서 전달
//public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private MemberService memberService;
//    private Environment env;
//
//    //인증=주민증=스스로증명 -> 아이디/패스워드에 대해서 검증하는 행위
//    public AuthenticationFilter(AuthenticationManager authenticationManager, MemberService memberService, Environment env) {
//        super.setAuthenticationManager(authenticationManager);
//        this.memberService = memberService;
//        this.env = env;
//        //setFilterProcessesUrl("/login");
//    }
//    //attempAu
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
//            MemberVO user = new ObjectMapper().readValue(request.getInputStream(), MemberVO.class);
//
//            if(user==null) {
//                throw new RuntimeException("memberService is null");
//            }
//            System.out.println(user);
//
//            return getAuthenticationManager().authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            user.getMemId(),
//                            user.getMemPw(),
//                            new ArrayList<>()
//                    )
//            );
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to read user data from request", e);
//        } catch (AuthenticationException e) {
//            throw new RuntimeException("Failed to authenticate user", e);
//        }
//    }
//
//
////    @Override
////    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
////
////        String userName = ((User) authResult.getPrincipal()).getUsername();
////        System.out.println("userName(ID): " + userName);
////
////        MemberVO memberDetail = memberService.getUserById(userName);
////        System.out.println("memberDetail: 멤버디테일 확인 " + memberDetail);
////
////        String token = Jwts.builder()
////                .setSubject(memberDetail.getMemId())
////                .setExpiration(new Date(System.currentTimeMillis() +
////                                            Long.parseLong(env.getProperty("token.expiration_time"))))
////                .signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret"))
////                .compact();
////
////        response.addHeader("token", token);
////        response.addHeader("auth", memberDetail.getAuth());
////        response.addHeader("ID", memberDetail.getMemId());
////    }
//}
