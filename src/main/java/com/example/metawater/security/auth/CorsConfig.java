//package com.example.metawater.security.auth;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//public class CorsConfig {
//
//   @Bean //Cross-Origin Resource Sharing
//   public CorsFilter corsFilter() {
//      CorsConfiguration config = new CorsConfiguration();
//      config.setAllowCredentials(true);
//      config.addAllowedOriginPattern("*"); // 허용할 URL
//      config.addAllowedHeader("*"); //허용할 Header
//      config.addAllowedMethod("*"); //허용할 Http Method
//
//       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//       source.registerCorsConfiguration("/auth/**", config);
//      return new CorsFilter(source);
//   }
//
//}
