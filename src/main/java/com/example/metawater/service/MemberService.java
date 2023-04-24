package com.example.metawater.service;

import com.example.metawater.domain.MemberVO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MemberService extends UserDetailsService {

    //회원가입
    public void createMember(MemberVO memberVO);

    //로그인
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException;

    //아이디 중복체크
    public MemberVO checkMemberInfo(String id);
    public MemberVO membersData(String id);
    public boolean updateMember(MemberVO memberVO);
    public void deleteMember(MemberVO memberVO);

    //    public boolean remove(Long userid);
//    public List<MemberVO> getUserList();

    //회원가입
//    public void insertMember(MemberVO memberVO) throws Exception;

//    public void updateMember(MemberVO user);
//    public void deleteMember(String id);
//    public boolean checkPw(MemberVO user) throws Exception;
}
