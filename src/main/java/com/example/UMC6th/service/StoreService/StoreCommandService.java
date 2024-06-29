package com.example.UMC6th.service.StoreService;

import com.example.UMC6th.domain.Review;
import com.example.UMC6th.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request);
}