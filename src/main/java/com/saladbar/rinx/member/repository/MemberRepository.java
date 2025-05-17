package com.saladbar.rinx.member.repository;

import com.saladbar.rinx.model.dto.CreatedMemberView;
import com.saladbar.rinx.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MemberRepository extends JpaRepository<Member, Long> {
    CreatedMemberView findByMemberId(long id);
    Set<CreatedMemberView> findAllBy();
}
