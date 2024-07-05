package com.example.UMC6th.service.StoreService;

import com.example.UMC6th.aws.s3.AmazonS3Manager;
import com.example.UMC6th.converter.ReviewImageConverter;
import com.example.UMC6th.converter.StoreConverter;
import com.example.UMC6th.domain.Review;
import com.example.UMC6th.domain.Uuid;
import com.example.UMC6th.repository.*;
import com.example.UMC6th.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final UuidRepository uuidRepository;
    private final ReviewImageRepository reviewImageRepository;
    private final AmazonS3Manager s3Manager;

    @Override
    public Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request) {
        Review review = StoreConverter.toReview(request);
        String uuid = UUID.randomUUID().toString();
        Uuid savedUuid = uuidRepository.save(Uuid.builder()
                .uuid(uuid).build());

        String pictureUrl = s3Manager.uploadFile(s3Manager.generateReviewKeyName(savedUuid), request.getReviewPicture());
        review.setMember(memberRepository.findById(memberId).get());
        review.setStore(storeRepository.findById(storeId).get());
        reviewImageRepository.save(ReviewImageConverter.toReviewImage(pictureUrl, review));
        return reviewRepository.save(review);
    }
}