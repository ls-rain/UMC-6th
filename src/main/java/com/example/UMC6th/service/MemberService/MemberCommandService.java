package com.example.UMC6th.service.MemberService;

import com.example.UMC6th.domain.Member;
import com.example.UMC6th.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
}