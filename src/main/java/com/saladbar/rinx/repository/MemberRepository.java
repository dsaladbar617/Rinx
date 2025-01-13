package com.saladbar.rinx.repository;

import com.saladbar.rinx.dto.CreatedMemberView;
import com.saladbar.rinx.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MemberRepository extends JpaRepository<Member, Long> {
    CreatedMemberView findByMemberId(long id);
    Set<CreatedMemberView> findAllBy();
}
