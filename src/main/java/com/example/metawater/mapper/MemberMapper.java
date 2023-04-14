package com.example.metawater.mapper;

import com.example.metawater.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {
    public List<MemberVO> findAllUsers();


    public MemberVO findUser(@Param("id") String id);

    public MemberVO getUser(String id);
    //회원가입
    public void insertMember(MemberVO memberVO);

//    public MemberVO getUserById(@Param("id") String id);

    //로그인
    //public UserDTO loginMember(UserDTO user);

    //로그인 pw 조회
    //public String readPw(@Param("id") String id);

    //회원정보 변경
//    public void updateMember(MemberVO user);

    //회원 탈퇴
//    public void deleteMember(@Param("id") String id);
}
