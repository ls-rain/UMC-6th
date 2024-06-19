package com.example.UMC6th.web.controller;

import com.example.UMC6th.apiPayLoad.ApiResponse;
import com.example.UMC6th.converter.MemberConverter;
import com.example.UMC6th.domain.Member;
import com.example.UMC6th.service.MemberService.MemberCommandService;
import com.example.UMC6th.web.dto.MemberRequestDTO;
import com.example.UMC6th.web.dto.MemberResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}