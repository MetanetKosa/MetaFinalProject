//package com.example.metawater.controller;
//
//import com.example.metawater.domain.MemberVO;
//import com.example.metawater.service.MemberService;
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//class MemberTest {
//    @Autowired
//    MemberVO memberVO;
//
//    @Autowired
//    MemberService memberService;
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    @DisplayName("1. 유저 데이터 생성하기")
//    @Test
//    void test_1(){
//        String encPassword = passwordEncoder.encode("test_password");
//        MemberVO memberVO = new MemberVO();
//        memberVO.setMemPw(encPassword);
//        memberVO.setMemName("level");
//        memberVO.setMemPhone("000-2222-111");
//        memberVO.setMemEmail("email@naver.com");
//        memberVO.setAuth("ROLE_ADMIN");
//
//        memberService.createMember(memberVO);
////        assertThat(savedUser.getMemId()).isEqualTo(savedUser.getMemId());
//    }
//
//    @DisplayName("2. 유저정보 검색 후 비밀번호 비교")
//    @Test
//    void test_2(){
//
//        String userId = "test_user";
//        String userPw = "test_password";
//        UserDetails user = memberService.loadUserByUsername(userId);
//
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, userPw);
//        authenticationManager.authenticate(authenticationToken);
//
//        assertThat(authenticationToken.getCredentials()).isEqualTo(userPw);
//
//        System.out.println("getCredentials 데이터: " + authenticationToken.getCredentials());
//        System.out.println("userPw 멤버 PW: " + userPw);
//
////        assertThat(memberVO.getMemPw()).isEqualTo(encPassword);
//    }
//
//}