//package com.example.metawater.security;
//
//import com.example.metawater.service.MemberService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class TokenRequestFilter extends OncePerRequestFilter {
//    private final MemberService memberService;
//    private final JwtUtil jwtUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            if ("/user/login".equals(request.getRequestURI())) {
//                doFilter(request, response, filterChain);
//            } else {
//                String token = parseJwt(request);
//                if (token == null) {
//                    response.sendError(403);    //accessDenied
//                } else {
//                    DecodedJWT tokenInfo = jwtUtil.decodeToken(token);
//                    if (tokenInfo != null) {
//                        String userId = tokenInfo.getClaim("userId").asString();
//                        UserDetails loginUser = userService.loadUserByUsername(userId);
//                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                                loginUser, null, loginUser.getAuthorities()
//                        );
//
//                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                        SecurityContextHolder.getContext().setAuthentication(authentication);
//                        doFilter(request, response, filterChain);
//
//                    } else {
//                        log.error("### TokenInfo is Null");
//                    }
//                }
//            }
//        } catch (Exception e) {
//            log.error("### Filter Exception {}", e.getMessage());
//        }
//    }
//
//    private String parseJwt(HttpServletRequest request) {
//        String headerAuth = request.getHeader("Authorization");
//        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
//            return headerAuth.substring(7, headerAuth.length());
//        }
//        return null;
//    }
//}