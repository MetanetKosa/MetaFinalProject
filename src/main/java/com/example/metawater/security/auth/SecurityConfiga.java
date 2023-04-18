package com.example.metawater.security.auth;

//
//@Configuration
//@Log4j2
//public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private final MemberService memberService;
//
//
////    public SecurityConfig(MemberService memberService) {
////        this.memberService = memberService;
////    }
////
////    /**
////     * 규칙 설정
////     * @param http
////     * @throws Exception
////     */
////    protected void configure(HttpSecurity http) throws Exception{
////        http.authorizeRequests()
////                .antMatchers("/login","signup","/resources/**").permitAll()//로그인 권한은 누구나, resources파일도 모든권한
////                //User,Admin 접근 허용
//                .antMatchers("/userAccess").hasRole("ROLE_MEMBER")
//                .antMatchers("/userAccess").hasRole("ROLE_ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .and()
//                .csrf().disable(); //로그인창
//    }
//
//    /**
//     * 로그인 인증 처리 메소드
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(memberService).passwordEncoder(new BCryptPasswordEncoder());
//    }


//}
