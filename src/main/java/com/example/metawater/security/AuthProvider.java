package com.example.metawater.security;

import com.example.metawater.domain.MemberDTO;
import com.example.metawater.domain.MemberVO;
import com.example.metawater.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//@Component
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    MemberService memberService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("AuthProvider 확인");
        String id = authentication.getName();
        String password = authentication.getCredentials().toString();
        MemberVO memberVO = (MemberVO)memberService.loadUserByUsername(id);
        System.out.println("아이디: " + id );

        if (memberVO == null) {
            System.out.println("UserNameNotFoundException");
            throw new UsernameNotFoundException(id);
        } else if (!memberVO.getMemPw().equals(password)) {
            System.out.println("BadCredentialException");
            throw new BadCredentialsException(id);
        }  else if (!memberVO.isAccountNonLocked()) {
            throw new LockedException("LockedException");
        }
//        else if (memberVO.getAuthStatus() == 0) {
//            System.out.println("NotAuthenticatedException");
//            throw new NotAuthenticatedException(id);
//        }



        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
