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
import java.util.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO implements UserDetails{

    private Integer memNo;
//    @NotBlank(message="아이디는 필수 입력값입니다.")
    private String memId;
//    @NotBlank(message="비밀번호는 필수 입력값입니다.")
//    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{4,10}", message = "비밀번호는 4~10자 영문 대/소문자, 숫자, 특수문자를 사용하세요.")
    private String memPw;
    private String memName;
    private String memPhone;
//    @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
    private String memEmail;
    private String auth;
    private Integer status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(auth));
    }

    @Override
    public String getUsername() {return memId;}

    @Override
    public String getPassword() {
        return memPw;
    }

    @Override
    public boolean isAccountNonExpired() { return true;}

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status == 1;
    }



}
