package com.example.UMC6th.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class ReviewDTO {
        @NotBlank
        String title;
        @NotNull
        Float score;
        @NotBlank
        String body;
    }
}
