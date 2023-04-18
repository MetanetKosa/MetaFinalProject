package com.example.metawater.security;


import com.example.metawater.domain.MemberVO;
import com.example.metawater.mapper.MemberMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private MemberMapper memberMapper;
    //private CustomUserDetailService customUserDetailService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    //로그인 처리 /인증필터
    public AuthenticationFilter(AuthenticationManager authenticationManager,MemberMapper memberMapper){
        super.setAuthenticationManager(authenticationManager);
        this.memberMapper = memberMapper;
        //이 주소가 호출되면 spring security 가 낚아채서 로그인작업을 진행해준다.
        setFilterProcessesUrl("/auth/login");
    }

    @Override //사용자의 인증 요청 처리,보안 유지 /인증시도
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            MemberVO mem = new ObjectMapper().readValue(request.getInputStream(), MemberVO.class);
            logger.info("===============request에서=======getMemId확인===== " +mem.getMemId());
            MemberVO memberVO = memberMapper.findByUserId(mem.getMemId());
            logger.info("---------------memberVO객체 값---------------" + memberVO.getMemId());
            //customUserDetailService.loadUserByUsername(memberVO.getMemId());

            if (memberVO != null) {
                System.out.println("===========attemptAuthentication 맴버================");
                return getAuthenticationManager().authenticate(
                        new UsernamePasswordAuthenticationToken(
                                memberVO.getMemId(),
                                memberVO.getMemPw(),
                                new ArrayList<>())
                );
            } else {
                throw new UsernameNotFoundException("아이디 없음");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //토큰 생성
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        String userName = ((User)authResult.getPrincipal()).getUsername();

        String jwt = Jwts.builder()
                .setHeaderParam("type", "jwt")
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis()+1*(1000*60*60*24*365)))
                .signWith(SignatureAlgorithm.HS256, "hello")
                .compact();
        response.addHeader("token",jwt);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
    }
}
