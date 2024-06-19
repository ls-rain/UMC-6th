package com.example.UMC6th.service.MemberService;

import com.example.UMC6th.domain.Member;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);
}