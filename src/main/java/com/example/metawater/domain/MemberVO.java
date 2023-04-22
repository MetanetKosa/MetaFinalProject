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
//public class MemberVO{

    private Long memNo;
    private String memId;
    private String memPw;
    private String memName;
    private String memPhone;
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
