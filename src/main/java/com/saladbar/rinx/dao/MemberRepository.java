package com.saladbar.rinx.dao;

import com.saladbar.rinx.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
