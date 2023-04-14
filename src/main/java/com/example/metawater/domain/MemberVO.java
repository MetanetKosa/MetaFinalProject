package com.example.metawater.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO implements UserDetails {

    private Long mem_no;

    //UserDTO user;
    private String mem_id;     //ID
    private String mem_pw;    //PW
    private String mem_name;
    private String mem_phone;
    private String mem_email;
    private String auth;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
    //private Long enabled;
    //private List<AuthVO> auth;
}
