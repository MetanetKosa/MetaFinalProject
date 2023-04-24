package com.example.metawater.service;

import com.example.metawater.domain.MemberVO;
import com.example.metawater.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class MemberServiceImpl implements MemberService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // 회원가입
    @Override
    public void createMember(MemberVO memberVO) {
//        System.out.println("pw ㅇ---------------" +memberVO.getMemPw() );
        memberVO.setMemPw(passwordEncoder.encode(memberVO.getMemPw()));
//        System.out.println("pw 인코딩된 값---------------" + passwordEncoder.encode(memberVO.getMemPw()) );

        memberVO.setAuth("ROLE_USER");
        memberVO.setStatus(1);
//        System.out.println("createMember 회원가입 auth, status 값 확인" + memberVO);
        memberMapper.insertMember(memberVO);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        logger.info("=========== loadUserByUsername 메서드 실행한다. ================");
        MemberVO member = memberMapper.findByUserId(username);
//        logger.info("------------member데이터 전체-------------" + member);
//        logger.info("------------member.getAuth()-------------" + member.getAuth());
        return member;
    }

    @Override
    public MemberVO checkMemberInfo(String id) {
//        System.out.println("-----------------memberServiceImple 아이디 중보체크"+memberMapper.checkMemberInfo(id));
        return memberMapper.checkMemberInfo(id);
    }

    @Override
    public boolean updateMember(MemberVO memberVO) {
//        System.out.println("-----updateMember 아이디 중보체크"+memberMapper.updateMember(memberVO));
        return memberMapper.updateMember(memberVO) == 1;
    }

    @Override
    public void deleteMember(MemberVO memberVO) {
//        MemberVO member = memberMapper.findByUserId(memberVO.getMemId());
//        System.out.println("delete 된 데이터 삭제");
        memberMapper.deleteMember(memberVO);
    }

    @Override
    public MemberVO membersData(String id) {
        return memberMapper.findByUserId(id);
    }

    //회원정보 변경
//    public void updateMember(String mem_id, MemberVO updateUser) {
//        MemberVO memberVO = userMapper.findUser(mem_id);
//
//        if (memberVO != null) {
//            memberVO.setMemPw(memberVO.getMemPw());
//            memberVO.setMemName(memberVO.getMemName());
//            memberVO.setMemName(memberVO.getMemEmail());
//            memberVO.setMemName(memberVO.getMemPhone());
//            userMapper.updateMember(user);
//        } else {
//            throw new IllegalStateException("회원정보가 존재하지 않습니다.");
//        }
//    }



//        ManagerDTO manager = managerMapper.managerGetUserByIdAndPassword(username);
//        if (member != null){
//            System.out.println("멤버 권한 부여");
//            String memberId = member.getMemId();
//            String memberPw = member.getMemPw();
//            System.out.println("멤버 권한 부여memberId " + memberId);
//            System.out.println("멤버 권한 부여memberPw " + memberPw);
//            List<GrantedAuthority> authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER")); // member 객체에 ROLE_USER role 추가// member 객체에 ROLE_USER role 추가
//            logger.info("-------------authorities----------------" + authorities);
//            UserDetails userDetails = new User(memberId,memberPw,authorities);
//            return userDetails;
//        } else {
//            throw new UsernameNotFoundException("id :인 " + username + " 을 찾을 수 없습니다.");
//        }




    //로그인
//    @Override
//    public UserDetails loadUserByUsername(String memId) throws UsernameNotFoundException {
//        //authentication 매니저가 낚아챔
//        log.info("MemberServiceImpl클래스 에서 loadUserByUsername 진입");
//        //여기서 받은 유저 아이디와 패스워드와 비교하여 로그인 인증
//        MemberVO findUser = memberMapper.findByUserId(memId);
//
//        return new MemberVO(findUser);
//    }
//  return User.builder()
//          .username(findUser.getMemId())
//            .password(findUser.getMemPw())
//            .roles()
//                .build();
    // 입력한 정보와 일치하는 회원이 있는지 판별
//    public boolean checkMemberInfo(MemberDTO memberDTO) throws UsernameNotFoundException {
//        //vue에서 가져온 데이터//TODO: vue에서 가져온 MemberDTO()은 무엇일까?
//        String memId = memberDTO.getMemId();
//        MemberVO findUser = memberMapper.findByUserId(memId);
//
//        if (memberVO != null && memberVO.getUsername().equals(findUser.getUsername())) {
//            return true;
//        }
//        return false;
//    }




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
