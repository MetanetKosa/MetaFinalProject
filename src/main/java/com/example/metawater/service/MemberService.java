package com.example.metawater.service;

import com.example.metawater.domain.MemberVO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService extends UserDetailsService {

    public void createMember(MemberVO memberVO);

//    public MemberVO getUserById(String id);

//    public boolean remove(Long userid);
//    public List<MemberVO> getUserList();

    //회원가입
//    public void insertMember(MemberVO memberVO) throws Exception;

//    public void updateMember(MemberVO user);
//    public void deleteMember(String id);
//    public boolean checkPw(MemberVO user) throws Exception;
}
