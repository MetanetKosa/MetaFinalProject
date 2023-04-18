package com.example.metawater.service;

import com.example.metawater.domain.MemberVO;
import com.example.metawater.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void createMember(MemberVO memberVO) {
        String password = memberVO.getMemPw();
        //memberVO.getMemPw(encoder.encode(password));
        System.out.println(memberVO);
        memberMapper.insertMember(memberVO);
    }

//    @Override
//    public MemberVO getUserById(String id) {
//        return memberMapper.getUserById(id);
//    }

    //인증
    //로그인 후 db에서 데이터 확인 후 맞으면 session 발급
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {MemberVO memberVO = memberMapper.getUser(username);
        System.out.println(memberVO);
        if(memberVO == null) {
            throw new UsernameNotFoundException("id: " + username + " is not found");
        }

        String id = memberVO.getMemId();
        String pw = memberVO.getMemPw();
        String auth = memberVO.getAuth();
        System.out.println("id: "+id+", pw: "+pw+", auth: "+auth);

        return User.builder()
                .username(id)
                .password(pw)
                .authorities(auth)
                .build();

        //return new User(memberVO.getMem_name(), memberVO.getMem_pw(), Collections.singleton(new SimpleGrantedAuthority(memberVO.getAuth())));
    }

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

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        MemberVO user = memberMapper.getUser(username);
//        System.out.println(user);
//        if(user == null) {
//            throw new UsernameNotFoundException("id: " + username + " is not found");
//        }
//
////        String id = user.getUsername();
////        String pw = user.getPassword();
////        String auth = user.getAuth();
////        System.out.println("id: "+id+", pw: "+pw+", auth: "+auth);
//
////        return User.builder()
////                .username(id)
////                .password(pw)
////                .authorities(auth)
////                .build();
//
//        return new User(user.getUsername(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getAuth())));
//    }
}
