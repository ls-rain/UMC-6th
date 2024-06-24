package com.example.UMC6th.repository;

import com.example.UMC6th.domain.Member;
import com.example.UMC6th.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByMember(Member member, Pageable pageable);
}
