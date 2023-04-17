package com.example.metawater.security.auth;

import com.example.metawater.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
/**
 * Spring Security가 auth/login 요청이 들어오면
 * 로그인이 완료되면 Security Session 을 생성한다. ( SecurityHolder )
 * Object Type => Authentication 타입 객체
 * Authentication 안에 User 정보가 있어야 함.
 * User Object Type => UserDetails Type 객체
 *
 * Security Session -> Authentication -> UserDetails(PrincipalDetails)
 */
@SuppressWarnings("serial") //노란색으로 warnings이 나타나는 부분 제거
public class PrincipalDetails implements UserDetails{

	private MemberVO member;

    public PrincipalDetails(MemberVO member){
        this.member = member;
    }

    public MemberVO getUser() {
		return member;
	}

    @Override
    public String getPassword() {
        return member.getMemPw();
    }

    @Override //시큐리티의 userName -> 따라서 얘는 인증할 때 id를 봄
    public String getUsername() {
        return member.getMemId();
    }

    @Override //계정이 만료되지 않았는지 리턴(true: 만료 안됨)
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override //계정이 잠겨있는지 않았는지 리턴(true: 잠기지 않음)
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override //계정이 활성화(사용가능)인지 리턴(true: 활성화)
    public boolean isEnabled() {
        return true;
    }

    //계정이 갖고 있는 권한 목록은 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(member.getRoles()));
//        member.getRoleList().forEach(r -> {
//        	authorities.add(()->{ return r;});
//        });
        return authorities;
    }
}
