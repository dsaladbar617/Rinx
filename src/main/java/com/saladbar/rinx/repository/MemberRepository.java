package com.saladbar.rinx.repository;

import com.saladbar.rinx.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
