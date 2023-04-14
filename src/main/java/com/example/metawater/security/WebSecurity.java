package com.example.metawater.security;
import com.example.metawater.service.MemberService;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private MemberService memberService;
    private BCryptPasswordEncoder passwordEncoder; //비밀번호 암호화
    private Environment env;

    public WebSecurity(Environment env, MemberService memberService, BCryptPasswordEncoder passwordEncoder) {
        this.env = env;
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/error");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //권한에 따른 허용 URL 설정
        http.csrf().disable()
                .authorizeRequests()
                //.antMatchers("/WEB-INF/", "/META-INF/").permitAll()
                .antMatchers("/login", "/signup").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/member/**").hasAnyRole("MEMBER", "ADMIN")
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(getAuthenticationFilter())

                //login 설정
                .formLogin()
                .loginPage("/login")
                .usernameParameter("id")
                .passwordParameter("password")
                .defaultSuccessUrl("/")

                //.successForwardUrl("/")

                //logout 설정
                .and()

                .logout()
                //.logoutUrl("/logout")
                //.deleteCookies("JSESSIONID")
                //.invalidateHttpSession(true)
                .logoutSuccessUrl("/");

                //.and()
                //.exceptionHandling()
                //.accessDeniedPage("/denied");
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager(), memberService, env);
        return authenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder);
    }
}
