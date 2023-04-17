package com.example.metawater.controller;

import com.example.metawater.domain.MemberVO;
import com.example.metawater.service.MemberService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    MemberVO memberVO;

    @Autowired
    MemberService memberService;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @DisplayName("1. 유저 데이터 생성하기")
    @Test
    void test_1(){
        String encPassword = passwordEncoder.encode("test_password");
        MemberVO memberVO = new MemberVO();
        memberVO.setMemPw(encPassword);
        memberVO.setMemName("level");
        memberVO.setMemPhone("000-2222-111");
        memberVO.setMemEmail("email@naver.com");
        memberVO.setAuth("ROLE_ADMIN");

        memberService.createMember(memberVO);
//        assertThat(savedUser.getMemId()).isEqualTo(savedUser.getMemId());
    }

    @DisplayName("2. 유저정보 검색 후 비밀번호 비교")
    @Test
    void test_2(){
        String encPassword = passwordEncoder.encode("test_password");
//        memberService.findByUserId("test_user");
//        MemberVO mem = memberVO.findByUserId("test_user")
//                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        assertThat(memberVO.getMemPw()).isEqualTo(encPassword);
    }

}