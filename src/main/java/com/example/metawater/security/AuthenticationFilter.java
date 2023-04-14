package com.example.metawater.security;

import com.example.metawater.domain.MemberVO;
import com.example.metawater.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private MemberService memberService;
    private Environment env;

    public AuthenticationFilter(AuthenticationManager authenticationManager, MemberService memberService, Environment env) {
        super.setAuthenticationManager(authenticationManager);
        this.memberService = memberService;
        this.env = env;
        //setFilterProcessesUrl("/login");
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            MemberVO user = new ObjectMapper().readValue(request.getInputStream(), MemberVO.class);

            if(user==null) {
                throw new RuntimeException("memberService is null");
            }
            System.out.println(user);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getMemId(),
                            user.getMemPw(),
                            new ArrayList<>()
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to read user data from request", e);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Failed to authenticate user", e);
        }
    }


//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//
//        String userName = ((User) authResult.getPrincipal()).getUsername();
//        System.out.println("userName(ID): " + userName);
//
//        MemberVO memberDetail = memberService.getUserById(userName);
//        System.out.println("memberDetail: 멤버디테일 확인 " + memberDetail);
//
//        String token = Jwts.builder()
//                .setSubject(memberDetail.getMem_id())
//                .setExpiration(new Date(System.currentTimeMillis() +
//                                            Long.parseLong(env.getProperty("token.expiration_time"))))
//                .signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret"))
//                .compact();
//
//        response.addHeader("token", token);
//        response.addHeader("auth", memberDetail.getAuth());
//        response.addHeader("ID", memberDetail.getMem_id());
//    }
}
