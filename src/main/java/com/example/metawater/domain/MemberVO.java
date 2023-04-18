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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

    private Long memNo;

    //UserDTO user;
    @NotBlank(message="아이디는 필수 입력값입니다.")
    private String memId;     //ID
//    @NotBlank(message="비밀번호는 필수 입력값입니다.")
//    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{4,10}", message = "비밀번호는 4~10자 영문 대/소문자, 숫자, 특수문자를 사용하세요.")
    private String memPw;    //PW
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "이름은 특수문자를 제외한 2~10자리여야 합니다.")
    private String memName;
    private String memPhone;
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
    private String memEmail;
    private String roles;
//    private List<MemberAuthDTO> roles;

    // ENUM으로 안하고 ,로 해서 구분해서 ROLE을 입력 -> 그걸 파싱!!
//    public List<String> getRoleList(){
//        if(this.roles.length() > 0){
//            return Arrays.asList(this.roles.split(","));
//        }
//        return new ArrayList<>();
//    }

}
