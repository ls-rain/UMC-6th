package com.example.UMC6th.web.controller;

import com.example.UMC6th.apiPayLoad.ApiResponse;
import com.example.UMC6th.converter.StoreConverter;
import com.example.UMC6th.domain.Review;
import com.example.UMC6th.service.StoreService.StoreCommandService;
import com.example.UMC6th.validation.annotation.ExistMember;
import com.example.UMC6th.validation.annotation.ExistStore;
import com.example.UMC6th.web.dto.StoreRequestDTO;
import com.example.UMC6th.web.dto.StoreResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReviewDTO request,
                                                                            @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                            @ExistMember @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }
}
