package com.soa.instakram.member.dto.request;


import com.soa.instakram.global.validation.NotDuplicate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {

    @NotDuplicate(target = "email")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,20}$",
             message = "8~20자리의 최소 하나 이상의 영문자, 숫자 또는 특수 문자 조합의 비밀번호여야 합니다.")
    private String password;

    @NotDuplicate(target = "instaId")
    @NotBlank(message = "인스타 아이디는 필수 입력 값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]{6,20}$", message = "8~20자리의 대소문자 영어 또는 숫자 또는 특수 문자('_', '.') 조합의 사용자 이름(인스타 아이디)이어야 합니다.")
    private String instaId;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    @Pattern(regexp = "^[a-zA-Z가-힣 ]{2,30}$", message = "2~30자리의 대소문자 영어 또는 한글 또는 공백 조합의 이름이어야 합니다.")
    private String name;


    /*
     * @CheckDuplicate: 중복체크하는 커스텀 어노테이션
     * @Email: email 형식 체크 But null, 빈 공백 문자열 허용.
     * @NotBlank: null, 빈 공백 문자열 허용 X
     * @Pattern: 허용할 패턴 정규표현식으로 정의
     * @Valid: 위의 작성한 기준으로 유효성을 체크 controller에서 구현
     */
}
