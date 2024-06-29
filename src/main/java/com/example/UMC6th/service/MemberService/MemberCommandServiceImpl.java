package com.example.UMC6th.service.MemberService;

import com.example.UMC6th.apiPayLoad.code.status.ErrorStatus;
import com.example.UMC6th.apiPayLoad.exception.handler.FoodCategoryHandler;
import com.example.UMC6th.converter.MemberConverter;
import com.example.UMC6th.converter.MemberPreferConverter;
import com.example.UMC6th.domain.FoodCategory;
import com.example.UMC6th.domain.Member;
import com.example.UMC6th.domain.mapping.MemberPrefer;
import com.example.UMC6th.repository.FoodCategoryRepository;
import com.example.UMC6th.repository.MemberRepository;
import com.example.UMC6th.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    @Override
    public Member joinMember(MemberRequestDTO.JoinDTO request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream().map(category -> {
            return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
        }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});
        return memberRepository.save(newMember);
    }
}