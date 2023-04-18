//package com.example.metawater.security;
//import com.example.metawater.service.MemberService;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
////authenticate 허가
////Authorization(인가) = 허가 Role 권한,
//@Configuration
//@EnableWebSecurity
//@Log4j2
//public class WebSecurity extends WebSecurityConfigurerAdapter {
//
//    private MemberService memberService;
//    private BCryptPasswordEncoder passwordEncoder; //비밀번호 암호화
//    private Environment env;
//
//    public WebSecurity(Environment env, MemberService memberService, BCryptPasswordEncoder passwordEncoder) {
//        this.env = env;
//        this.memberService = memberService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    //AnthenticationManager의 설정을 쉽게 처리할 수 있도록 도와주는 configure()메서드
//    //AuthenticationManagerBuilder는 말 그래도 코드를 통해서 직접 인증 매니저를 설정할 때 사용
//    @Override
//    public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/error");
//    }
//
//        @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //권한에 따른 허용 URL 설정
//        http.csrf().disable()
//                .authorizeRequests()
//                //.antMatchers("/WEB-INF/", "/META-INF/").permitAll()
//                //USER, ADMIN 접근 허용
//                .antMatchers("/login", "/signup").permitAll() //모든 사용자에게 허락
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/member/**").hasAnyRole("MEMBER", "ADMIN")
//                .antMatchers("/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(getAuthenticationFilter())
//
//                //login 설정
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login") //loginURL
//                //.failureUrl("/access_denied") //인증 실패 시 화면url, 로그인 form으로 파라미터값 error=true로 보낸다.
//                .usernameParameter("id")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/")
//
//                //.successForwardUrl("/")
//
//                //logout 설정
//                .and()
//
//                .logout()
//                //.logoutUrl("/logout")
//                //.deleteCookies("JSESSIONID")
//                //.invalidateHttpSession(true)
//                .logoutSuccessUrl("/");
//
//                //.and()
//                //.exceptionHandling()
//                //.accessDeniedPage("/denied");
//    }
//
//    private AuthenticationFilter getAuthenticationFilter() throws Exception {
//        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager(), memberService, env);
//        return authenticationFilter;
//    }
//
//    //AuthenticationManager 회원/관리자 구분
//    //로그인 인증 처리 메소드
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder);
//    }
//}
