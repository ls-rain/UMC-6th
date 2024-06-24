package com.example.UMC6th.converter;

import com.example.UMC6th.domain.Member;
import com.example.UMC6th.domain.Review;
import com.example.UMC6th.domain.enums.Gender;
import com.example.UMC6th.web.dto.MemberRequestDTO;
import com.example.UMC6th.web.dto.MemberResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request) {
        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();

    }

    public static MemberResponseDTO.MemberReviewDTO toMemberReviewDTO(Review review) {
        return MemberResponseDTO.MemberReviewDTO.builder()
                .name(review.getMember().getName())
                .storeName(review.getStore().getName())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static MemberResponseDTO.MemberReviewListDTO toMemberReviewListDTO(Page<Review> reviewList) {
        List<MemberResponseDTO.MemberReviewDTO> memberReviewDTOList = reviewList.stream().map(MemberConverter::toMemberReviewDTO).collect(Collectors.toList());
        return MemberResponseDTO.MemberReviewListDTO.builder()
                .reviewNum(memberReviewDTOList.size())
                .reviewList(memberReviewDTOList)
                .build();
    }
}