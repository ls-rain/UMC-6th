package com.example.UMC6th.web.controller;

import com.example.UMC6th.apiPayLoad.ApiResponse;

import com.example.UMC6th.domain.mapping.MemberMission;
import com.example.UMC6th.service.missionService.MissionQueryService;
import com.example.UMC6th.validation.annotation.ExistMember;
import com.example.UMC6th.web.dto.MemberResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionQueryService missionQueryService;

    @PostMapping("/{memberId}/{missionId}/complete")
    @Operation(summary = "진행중인 미션 진행 완료로 바꾸기 API", description = "진행완료시 완료된 미션으로 변경하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER4001", description = "사용자가 없습니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION4001", description = "미션이 없습니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버 아이디, path variable 입니다."),
            @Parameter(name = "missionId", description = "미션 아이디, path variable 입니다.")
    })
    public ApiResponse<String> missionComplete(@ExistMember @PathVariable("memberId") Long memberId,
                                                @PathVariable("missionId") Long missionId) {
        MemberMission changeStatus = missionQueryService.missionComplete(memberId, missionId);
        return ApiResponse.onSuccess(changeStatus.getStatus().toString());
    }
}
