package com.example.metawater.service;

import com.example.metawater.domain.MemberDTO;
import com.example.metawater.domain.MemberVO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService extends UserDetailsService {

    //회원가입
    public void createMember(MemberVO memberVO);

    //로그인
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException;

    //아이디 중복체크
    public MemberVO checkMemberInfo(String id);
    public MemberVO membersData(String id);
    public boolean updateMember(String id);

    //    public boolean remove(Long userid);
//    public List<MemberVO> getUserList();

    //회원가입
//    public void insertMember(MemberVO memberVO) throws Exception;

//    public void updateMember(MemberVO user);
//    public void deleteMember(String id);
//    public boolean checkPw(MemberVO user) throws Exception;
}
