package com.example.UMC6th.converter;

import com.example.UMC6th.domain.Review;
import com.example.UMC6th.web.dto.StoreRequestDTO;
import com.example.UMC6th.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static Review toReview(StoreRequestDTO.ReviewDTO request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }

    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}