package com.example.UMC6th.service.missionService;

import com.example.UMC6th.domain.Member;
import com.example.UMC6th.domain.enums.MissionStatus;
import com.example.UMC6th.domain.mapping.MemberMission;
import com.example.UMC6th.repository.MemberMissionRepository;
import com.example.UMC6th.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMission missionComplete(Long memberId, Long missionId) {
        MemberMission mission = memberMissionRepository.findMemberMissionByMemberIdAndMissionId(memberId, missionId);
        mission.setStatus(MissionStatus.COMPLETE);
        return memberMissionRepository.save(mission);
    }
}
