package com.example.metawater.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

//    @NotBlank(message="아이디는 필수 입력값입니다.")
    private String memId;     //ID
//    @NotBlank(message="비밀번호는 필수 입력값입니다.")
//    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{4,10}", message = "비밀번호는 4~10자 영문 대/소문자, 숫자, 특수문자를 사용하세요.")
    private String memPw;
}
