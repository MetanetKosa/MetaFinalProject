package com.example.metawater.security;

import com.example.metawater.domain.MemberVO;
import com.example.metawater.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Role부여
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private MemberMapper memberMapper;

//    @Autowired
//    private ManagerMapper managerMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberVO member = memberMapper.findByUserId(username);
//        ManagerDTO manager = managerMapper.managerGetUserByIdAndPassword(username);
        if (member != null){
            System.out.println("멤버 권한 부여");
            String memberId = member.getMemId();
            String memberPw = member.getMemPw();
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER")); // member 객체에 ROLE_USER role 추가
            return User.builder()
                    .username(memberId)
                    .password(memberPw)
                    .authorities(authorities)
                    .build();
        }
//        else if (manager != null){
//            System.out.println("어드민 권한 부여");
//            String managerId = manager.getId();
//            String managerPw = manager.getPassword();
//            List<GrantedAuthority> authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER")); // manager 객체에 ROLE_MANAGER role 추가
//            return User.builder()
//                    .username(managerId)
//                    .password(managerPw)
//                    .authorities(authorities)
//                    .build();
//        }
        else {
            throw new UsernameNotFoundException("id : " + username + " is not found");
        }
    }
}
