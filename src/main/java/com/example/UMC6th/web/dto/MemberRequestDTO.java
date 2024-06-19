package com.example.UMC6th.web.dto;

import com.example.UMC6th.validation.annotation.ExistCategories;
import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDTO{
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}
