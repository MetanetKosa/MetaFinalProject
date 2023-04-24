package com.example.metawater.controller;

import com.example.metawater.domain.MemberVO;
import com.example.metawater.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/auth")
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    MemberService memberService;

    //회원삭제
    @PostMapping("/delete")
    public void deleteMember(@RequestBody MemberVO memberVO) {
//        System.out.println("deleteUser 확인 " + memberVO);
        memberService.deleteMember(memberVO);
    }

    //회원가입 //get/post
    @PostMapping("/signup")
    public ResponseEntity<MemberVO> createUser(@RequestBody MemberVO member) {
        //System.out.println(member);
        memberService.createMember(member);

        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    //token보낸 후 정보 가져오기
    @GetMapping("/members/{id}")
    public MemberVO membersData(@PathVariable String id){
        //System.out.println("id 확인 "+ id);
        MemberVO memberVO = memberService.membersData(id);
        return memberVO;
    }

    //id 중복확인
    @GetMapping("/checkid/{id}")
    public MemberVO checkId(@PathVariable String memId) {
        //System.out.println("결과 확인"+memId);
        MemberVO memberVO= memberService.checkMemberInfo(memId);
        //System.out.println("결과 확인 memberService "+memberService.checkMemberInfo(memId));
        return memberVO;
//        if(memberService.checkMemberInfo(memId)){
//            return new ResponseEntity<>("success",HttpStatus.OK);
//        }
//        return new ResponseEntity<>("fail",HttpStatus.OK);
    }
    

    //회원수정
//    @PatchMapping("/update")
    @PostMapping("/update")
    public boolean updateMember(@RequestBody MemberVO memberVO) {
//        System.out.println("update데이터 확인 " + memberVO);

        boolean result = memberService.updateMember(memberVO);
//        System.out.println("update데이터 후 데이터 확인" + result);
        return result;
    }

    //회원탈퇴 전 password확인
//    @PatchMapping("/update")
//    @PostMapping("/checkDelete")
//    public MemberVO checkDelete(@RequestBody MemberVO mem) {
//        System.out.println("checkDelete getMemId 데이터 확인: " +mem.getMemId());
//        System.out.println("checkDelete getMemPw 데이터 확인: " +mem.getMemPw());
//        MemberVO memberVO = memberService.checkMemberInfo(mem.getMemId());
//        System.out.println("update데이터 후 데이터 확인" + memberVO);
//        return memberVO;
//    }
//
//    //회원탈퇴
//    @DeleteMapping("/users/{mem_id}")
//    public void deleteUser(@PathVariable String mem_id) {
//        MemberVO memberVO = userService.findUser(mem_id);
//
//        if(user == pw 인코딩된 값) {
//            throw new UserNotFoundException(String.format("ID[%s] not found", mem_id));
//        } userService.deleteMember(mem_id);
//    }

  

//    @Secured("ROLE_USER")
//    @PostMapping ("/aftersignup")
//    public String aftersignup(){
//        return "여기는 멤버 토큰있는사람만 올수있어";
//    }

    //로그인
//    @PostMapping("login")
//    public String login(@RequestBody MemberDTO memberDTO, Authentication authentication) {
//        log.info("----------------- login ------------------------------");
//        PrincipalDetails memberPrincipal = (PrincipalDetails) authentication.getPrincipal();
//        System.out.println("loginController: "+memberPrincipal.getUser().getMemId());
//        System.out.println("loginController : "+memberPrincipal.getUser().getMemName());
//        System.out.println("loginController: "+memberPrincipal.getUser().getMemPw());
//
//        return "/";
//    }
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
