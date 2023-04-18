package com.example.metawater.service;

import com.example.metawater.domain.MemberDTO;
import com.example.metawater.domain.MemberVO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService extends UserDetailsService {

    //회원가입
    public void createMember(MemberVO memberVO);
    //로그인
//    UserDetails loadUserByUsername(String memId);
    boolean checkMemberInfo(MemberDTO memberDTO);
    public boolean getId(String id);

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException;

    //    public boolean remove(Long userid);
//    public List<MemberVO> getUserList();

    //회원가입
//    public void insertMember(MemberVO memberVO) throws Exception;

//    public void updateMember(MemberVO user);
//    public void deleteMember(String id);
//    public boolean checkPw(MemberVO user) throws Exception;
}
