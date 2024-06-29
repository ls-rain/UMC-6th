package com.example.UMC6th.validation.annotation;

import com.example.UMC6th.validation.validator.CategoriesExistValidator;
import com.example.UMC6th.validation.validator.PageCheckValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageCheckValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "페이지 번호가 0미만입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
