package com.example.UMC6th.domain.mapping;

import com.example.UMC6th.domain.Member;
import com.example.UMC6th.domain.Mission;
import com.example.UMC6th.domain.common.BaseEntity;
import com.example.UMC6th.domain.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;

import static com.example.UMC6th.domain.enums.MissionStatus.CHALLENGING;
import static com.example.UMC6th.domain.enums.MissionStatus.COMPLETE;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'CHALLENGING'")
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void setStatus(MissionStatus status) {
        if(this.status == CHALLENGING){
            this.status = COMPLETE;

        }
    }
}
