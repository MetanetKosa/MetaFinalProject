package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.beans.SimpleBeanInfo;
import java.util.ArrayList;
import java.util.Collection;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO implements UserDetails {

    private Long memNo;

    //UserDTO user;
    @NotBlank(message="아이디는 필수 입력값입니다.")
    private String memId;     //ID
    @NotBlank(message="비밀번호는 필수 입력값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{4,10}", message = "비밀번호는 4~10자 영문 대/소문자, 숫자, 특수문자를 사용하세요.")
    private String memPw;    //PW
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "이름은 특수문자를 제외한 2~10자리여야 합니다.")
    private String memName;
    private String memPhone;
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
    private String memEmail;
    private String auth;

    //계정이 갖고 있는 권한 목록은 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection< GrantedAuthority > collectors = new ArrayList<>();
//        collectors.add() -> {
//            return "ROLE_MEMBER";
//        }
        collectors.add(new SimpleGrantedAuthority("Rold"));
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    //시큐리티의 userName -> 따라서 얘는 인증할 때 id를 봄
    @Override
    public String getUsername() {
        return null;
    }
    //계정이 만료되지 않았는지 리턴(true: 만료 안됨)
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    //계정이 잠겨있는지 않았는지 리턴(true: 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    //비밀번호가 만료되지 않았는지 리턴한다. (true: 만료 안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    //계정이 활성화(사용가능)인지 리턴(true: 활성화)
    @Override
    public boolean isEnabled() {
        return false;
    }
    //private Long enabled;
    //private List<AuthVO> auth;
}
