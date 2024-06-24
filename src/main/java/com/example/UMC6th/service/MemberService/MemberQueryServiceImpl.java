package com.example.UMC6th.service.MemberService;

import com.example.UMC6th.domain.Member;
import com.example.UMC6th.domain.Review;
import com.example.UMC6th.repository.MemberRepository;
import com.example.UMC6th.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> findMemberReview(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<Review> memberReviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return memberReviewPage;
    }
}