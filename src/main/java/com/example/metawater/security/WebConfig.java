package com.example.metawater.security;

import com.example.metawater.mapper.MemberMapper;
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
public class WebConfig extends WebSecurityConfigurerAdapter {

    private MemberMapper memberMapper;
//    private ManagerMapper managerMapper;

    private CustomUserDetailService customUserDetailService;

    public WebConfig(MemberMapper memberMapper,
                     CustomUserDetailService customUserDetailService) {
        this.memberMapper = memberMapper;
//        this.managerMapper = managerMapper;
        this.customUserDetailService = customUserDetailService;
    }

    //패스워드 암호화
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                //        .antMatchers("/**")
                .antMatchers("/auth")
                .antMatchers("/auth/error")
                .antMatchers("/auth/checkid")
                .antMatchers("/auth/signup");
        // 이 요청들에 대해서는 spring security 필터 체인을 적용하지 않겠다
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/auth").permitAll()
                .antMatchers("/auth/error").permitAll()
                .antMatchers("/auth/checkid").permitAll()
                .antMatchers("/auth/signup").permitAll()
                .antMatchers("/auth/aftersignup").access("hasRole('ROLE_USER')")
                .and()
                .formLogin().disable()
                .addFilter(authenticationFilter())
                .addFilter(JwtFilter()).authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .logout();
    }

    private JwtFilter JwtFilter() throws Exception {
        return new JwtFilter(authenticationManager(), memberMapper);
    }

    private AuthenticationFilter authenticationFilter() throws Exception {
        return new AuthenticationFilter(authenticationManager(), memberMapper);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
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

}
