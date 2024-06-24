package com.example.UMC6th.web.controller;

import com.example.UMC6th.apiPayLoad.ApiResponse;
import com.example.UMC6th.converter.MemberConverter;
import com.example.UMC6th.domain.Member;
import com.example.UMC6th.domain.Review;
import com.example.UMC6th.service.MemberService.MemberCommandService;
import com.example.UMC6th.service.MemberService.MemberQueryService;
import com.example.UMC6th.validation.annotation.ExistMember;
import com.example.UMC6th.web.dto.MemberRequestDTO;
import com.example.UMC6th.web.dto.MemberResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 API", description = "특정 사용자의 작성 리뷰 목록을 조회하는 API입니다. 페이징을 포함하고 Query String으로 페이지 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER4001", description = "사용자가 없습니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER4003", description = "사용자리뷰가 없습니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버 아이디, path variable 입니다."),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1페이지 입니다.")
    })
    public ApiResponse<MemberResponseDTO.MemberReviewListDTO> getMemberReviews(@PathVariable("memberId") Long memberId,
                                                                                @ExistMember @RequestParam(name = "page") Integer page){
        Page<Review> memberReview = memberQueryService.findMemberReview(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.toMemberReviewListDTO(memberReview));
    }
}