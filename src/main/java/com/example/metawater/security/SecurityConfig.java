package com.example.metawater.security;

import com.example.metawater.mapper.MemberMapper;
import com.example.metawater.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private MemberMapper memberMapper;
    private MemberService memberService;

    public SecurityConfig(MemberMapper memberMapper, MemberService memberService) {
        this.memberMapper = memberMapper;
        this.memberService = memberService;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
//                .antMatchers("/")
                .antMatchers("/auth/signup")
                .antMatchers("/auth/members/**")
                .antMatchers("/product/**")
                .antMatchers("/css/**", "/js/**", "/img/**");
        // 이 요청들에 대해서는 spring security 필터 체인을 적용하지 않겠다
        //                .antMatchers("/mypage/**")
//                .antMatchers("/auth/members")
//                .antMatchers("/order/**")
//                .antMatchers("/auth/update")
//                .antMatchers("/auth/delete")
//                .antMatchers("/product/{productNo}/**")
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests() // 요청에 의한 보안검사 시작
//                .antMatchers("/**").permitAll()//해당경로에 대한 모든 접근을 하용한다.
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/auth").access("hasRole('USER')")
                .antMatchers("/mypage").access("hasRole('USER')")
                .antMatchers("/order").access("hasRole('USER')")
                .antMatchers("/admin").access("hasRole('ADMIN')")// /show/mypage는 ADMIN권한을 가지고있는 사용자에게만 허용한다.
                .anyRequest().authenticated()//어떤 요청에도 보안검사를 한다.
                .and()
                .addFilter(getAuthenticationFilter()) //회원 로그인
            .addFilter(JwtFilter()).authorizeRequests()//회원 토큰 생성
            .and()
            .formLogin()
            .and()
            .logout();
    }
    //                .authorizeRequests().anyRequest().permitAll();
//                .antMatchers(HttpMethod.PATCH, "/api/**").authenticated() // PATCH 요청 권한 설정


    //토큰
    private JwtFilter JwtFilter() throws Exception {
        return new JwtFilter(authenticationManager(), memberMapper);
    }

    //인증 필터(사용자 이름, 비밀번호)
    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        return new AuthenticationFilter(authenticationManager(), memberMapper);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }

    //패스워드 암호화
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    /*
     * 시큐리티 설정 제거
     *
     * @Bean
     * public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
     * Exception {
     * return http.authorizeRequests().antMatchers("/").permitAll().and().build();
     * }
     */

    //                .antMatchers("/auth/modify/{memberIdx}","/auth/admin/").hasRole("MEMBER","ADMIN");
//                .antMatchers("/auth/signup").permitAll()
//                .antMatchers("/auth/login").permitAll()
//                .antMatchers("/auth/login").access("hasRole('ROLE_USER')")
}