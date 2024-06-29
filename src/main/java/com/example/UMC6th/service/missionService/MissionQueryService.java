package com.example.UMC6th.service.missionService;

import com.example.UMC6th.domain.mapping.MemberMission;

public interface MissionQueryService {
    MemberMission missionComplete(Long memberId, Long missionId);
}
