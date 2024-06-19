package com.example.UMC6th.repository;

import com.example.UMC6th.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
