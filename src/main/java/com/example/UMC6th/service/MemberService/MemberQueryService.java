package com.example.UMC6th.service.MemberService;

import com.example.UMC6th.domain.Member;
import com.example.UMC6th.domain.Mission;
import com.example.UMC6th.domain.Review;
import com.example.UMC6th.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

    Page<Review> findMemberReview(Long memberId, Integer page);

    Page<MemberMission> findProgressMission(Long memberId, Integer page);
}