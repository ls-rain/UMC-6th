package com.example.UMC6th.repository;

import com.example.UMC6th.domain.Member;
import com.example.UMC6th.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    @Query("SELECT mm FROM MemberMission mm JOIN Member m ON mm.member.id = :memberId AND mm.status = 'CHALLENGING'")
    Page<MemberMission> findAllByMember(Long memberId, Pageable pageable);

    MemberMission findMemberMissionByMemberIdAndMissionId(Long memberId, Long missionId);
}
