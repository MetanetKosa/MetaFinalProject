package com.example.metawater.controller;

import com.example.metawater.domain.MemberDTO;
import com.example.metawater.domain.MemberVO;
import com.example.metawater.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/auth")
public class MemberController {
    @Autowired
    MemberService memberService;

    //회원가입 //get/post
    @PostMapping("/signup")
    public ResponseEntity<MemberVO> createUser(@RequestBody MemberVO member) {
        System.out.println("회원가입 데이터 확인" + member.getPassword());
        member.setAuth("ROLE_MEMBER");
        System.out.println(member);
        memberService.createMember(member);

        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    //로그인  //get/post
    /**
     * 로그인 폼
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "/";
    }


//    @PostMapping("/login")  // .loginPage("LOGIN_PAGE")에서 설정한 LOGIN_PAGE와 일치해야 함
//    public String getLoginForm(@RequestBody MemberDTO memberDTO) {
//        System.out.println("아이디" + memberDTO.getMemId());
//        System.out.println("비밀번호" + memberDTO.getMemPw());
//
//        memberService.getUserById(memberDTO.getMemId());
//        System.out.println("로그인 성공");
//
//        return "/";
//    }

    @PostMapping("/logout") //post
    public void getLogout(){

    }

    //로그인한 사용자만 접근
    @GetMapping("/member")
    public String member() {
        return "user/member";
    }

    //관리자 권한이 있는 사용자만 접근
    @GetMapping("/admin")
    public String admin() {
        return "user/admin";
    }


//    //로그인을 하지 않은 사용자도 접근
//    @GetMapping("/all")
//    public void exAll(){
//        log.info("ex....");
//    }
//    //로그인한 사용자만 접근
//    @GetMapping("/member")
//    public void exMember(){
//        log.info("exMember....");
//    }
//    //관리자 권한이 있는 사용자만 접근
//    @GetMapping("/admin")
//    public void exAdmin(){
//        log.info("exAdmin...");
//    }

}
