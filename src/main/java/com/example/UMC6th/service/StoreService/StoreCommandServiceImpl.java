package com.example.UMC6th.service.StoreService;

import com.example.UMC6th.converter.StoreConverter;
import com.example.UMC6th.domain.Review;
import com.example.UMC6th.repository.MemberRepository;
import com.example.UMC6th.repository.ReviewRepository;
import com.example.UMC6th.repository.StoreRepository;
import com.example.UMC6th.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    private final StoreRepository storeRepository;

    @Override
    public Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request) {

        Review review = StoreConverter.toReview(request);

        review.setMember(memberRepository.findById(memberId).get());
        review.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }
}