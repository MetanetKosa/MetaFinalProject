package com.example.metawater.service;

import com.example.metawater.domain.MemberDTO;
import com.example.metawater.domain.MemberVO;
import com.example.metawater.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Collections;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private BCryptPasswordEncoder encoder;

    private MemberDTO memberDTO;
    private MemberVO memberVO;

//    회원가입
    @Override
    public void createMember(MemberVO memberVO) {
        String password = memberVO.getMemPw();
        memberVO.setMemPw(encoder.encode(password));
        System.out.println("회원가입 " + memberVO);
        memberMapper.insertMember(memberVO);
    }

    //로그인
    @Override
    public UserDetails loadUserByUsername(String memId) throws UsernameNotFoundException {
        //여기서 받은 유저 아이디와 패스워드와 비교하여 로그인 인증

        System.out.println("MemberserviceImpl메서드확인");
        System.out.println("MemberserviceImpl메서드확인memId데이터확인 " + memId);
        MemberVO findUser = memberMapper.getUserById(memId);
//        System.out.println("memberserviceImpl 아이디 데이터확인" + findUser.getMemId());
//        System.out.println("memberserviceImpl 비밀번호 데이터확인"+ findUser.getMemPw());
//        System.out.println("memberserviceImpl 이름 데이터확인"+ findUser.getMemName());

        return User.builder()
                .username("bb22")
                .password("$2a$10$cIAQoG5.zjBFHVnfmLyJmuTSsBdmm1tNStb5SCcgZyzgGlR2CTQSa")
                .roles() //TODO: 이 role()은 무엇일까?
                .build();
    }
//  return User.builder()
//          .username(findUser.getMemId())
//            .password(findUser.getMemPw())
//            .roles() //TODO: 이 role()은 무엇일까?
//                .build();
    // 입력한 정보와 일치하는 회원이 있는지 판별
    public boolean checkMemberInfo(MemberDTO memberDTO) throws UsernameNotFoundException {
        //vue에서 가져온 데이터//TODO: vue에서 가져온 MemberDTO()은 무엇일까?
        String memId = memberDTO.getMemId();
        MemberVO findUser = memberMapper.getUserById(memId);

        if (memberVO != null && memberVO.getUsername().equals(findUser.getUsername())) {
            return true;
        }
        return false;
    }




    //인증
    //로그인 후 db에서 데이터 확인 후 맞으면 session 발급
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        MemberVO memberVO = memberMapper.getUser(username);
//        System.out.println(memberVO);
//        if(memberVO == null) {
//            throw new UsernameNotFoundException("id: " + username + " is not found");
//        }
//
//        String id = memberVO.getMemId();
//        String pw = memberVO.getMemPw();
//        String auth = memberVO.getAuth();
//        System.out.println("id: "+id+", pw: "+pw+", auth: "+auth);
//
//        return User.builder()
//                .username(id)
//                .password(pw)
//                .authorities(auth)
//                .build();
//
////        return new User(memberVO.getUsername(), memberVO.getMemPw(), Collections.singleton(new SimpleGrantedAuthority(memberVO.getAuth())));
//    }

//
//    public void updateMember(MemberVO updateUser) {
//        MemberVO user = memberMapper.findUser(updateUser.getMem_id());
//
//        if (user != null) {
//            memberMapper.updateMember(user);
//        } else {
//            throw new IllegalStateException("회원정보가 존재하지 않습니다.");
//        }
//    }
//
//
//    public void deleteMember(String id) {
//        if (memberMapper.findUser(id) != null) {
//            memberMapper.deleteMember(id);
//        } else {
//            throw new IllegalStateException("회원정보가 존재하지 않습니다.");
//        }
//    }
//
//
//    public boolean checkPw(MemberVO user) {
//        return false;
//    }
////    @Override
////    public MemberVO getUser(String id) {
////        return memberMapper.getUser(id);
////    }
////
////    @Override
////    public MemberVO getUserById(String id) {
////        return memberMapper.getUserById(id);
////    }
//
//    @Override
//    public boolean remove(Long userid) {
//        //return userMapper.deleteUser(userid) == 1;
//        return true;
//    }

}
