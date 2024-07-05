package com.example.UMC6th.converter;

import com.example.UMC6th.domain.Review;
import com.example.UMC6th.domain.ReviewImage;

public class ReviewImageConverter {
    public static ReviewImage toReviewImage(String imageUrl, Review review){
        return ReviewImage.builder()
                .imageUrl(imageUrl)
                .review(review)
                .build();
    }
}
