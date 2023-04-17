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
import org.springframework.web.bind.annotation.*;

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
        member.setRoles("ROLE_MEMBER");
        System.out.println(member);
        memberService.createMember(member);

        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    /**
     * 로그인 폼
     * @return
     */
//    @RequestMapping(value = "/login")
//    public String member(@RequestParam(value="memId", required=false) String memId,
//                         @RequestParam(value="memPw", required=false) String memPw,
//                        @RequestBody MemberDTO memberDTO,
//                        @RequestParam(value="error", required=false) String error,
//                        @RequestParam(value="exception", required=false) String exception,
//                        Model model){
//        System.out.println("이로그인컨트롤러조차실행이안");
//        System.out.println("String memId, 확인" + memId);
//        System.out.println("String memPw, 확인" + memPw);
//        System.out.println("회원 아이디" + memberDTO.getMemId());
//        System.out.println("회원 비밀번호" + memberDTO.getMemPw());
        // 입력받은 정보가 회원정보와 일치하는지 확인
//        if(memberService.checkMemberInfo(memberDTO)){
//            model.addAttribute("error", error);
//        }
//        else{
//            model.addAttribute("error", error);
//            model.addAttribute("exception", "입력하신 정보와 일치하는 회원이 없습니다.");
//        }
//        return "/";
//    }
    @GetMapping("/login")
    public String login(Authentication authentication) {
        MemberVO memberPrincipal = (MemberVO) authentication.getPrincipal();
        System.out.println("loginController: "+memberPrincipal.getMemId());
        System.out.println("loginController : "+memberPrincipal.getMemName());
        System.out.println("loginController: "+memberPrincipal.getMemPw());

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