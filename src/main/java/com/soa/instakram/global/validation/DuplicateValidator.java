package com.soa.instakram.global.validation;

import com.soa.instakram.member.repository.MemberRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DuplicateValidator implements ConstraintValidator<NotDuplicate, String> {

    private String target;
    private final MemberRepository memberRepository;

    @Override
    public void initialize(NotDuplicate constraintAnnotation) {
        this.target = constraintAnnotation.target();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (target.equals("email")) {
            if (memberRepository.findByEmail(value).isPresent()) {
                addConstraintViolation(context, "중복된 이메일이 존재합니다.");
                return false;
            }
        }
        else if (target.equals("instaId")) {
            if (memberRepository.findByInstaId(value).isPresent()) {
                addConstraintViolation(context, "중복된 인스타 아이디가 존재합니다.");
                return false;
            }
        }
        return true;
    }

    private void addConstraintViolation(ConstraintValidatorContext context, String errorMessage) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
                .addConstraintViolation();
    }
}
