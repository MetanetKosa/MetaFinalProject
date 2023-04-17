package com.example.metawater.security;

import com.example.metawater.mapper.MemberMapper;
import com.example.metawater.security.jwt.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity // 시큐리티 활성화 -> 기본 스프링 필터체인에 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private CorsConfig corsConfig;

	@Bean  // 해당 메서드의 리턴되는 오브젝트를 IoC로 등록해준다.//TODO: 비밀번호 암호화
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	//CORS 허용
	//Security Session -> Authentication -> UserDetails(PrincipalDetails)
	@Override
	protected void configure(HttpSecurity http) throws Exception {
				http
				.addFilter(corsConfig.corsFilter())
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.formLogin().disable()
				.httpBasic().disable()

//				.addFilter(new JwtAuthorizationFilter(authenticationManager()))
				.addFilter(new JwtAuthorizationFilter(authenticationManager(), memberMapper))
				.authorizeRequests()
				.antMatchers("/**")
				.access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
				.anyRequest().permitAll();
	}
}






