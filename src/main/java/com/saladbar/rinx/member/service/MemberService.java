package com.saladbar.rinx.member.service;

import com.saladbar.rinx.model.dto.CreatedMemberView;
import com.saladbar.rinx.model.entity.Member;

import java.util.List;
import java.util.Set;

public interface MemberService {
    List<Member> findAll();
    Member findById(long id);
    Member save(Member member);
    void delete(Member member);
    CreatedMemberView findCreatedMember(long id);
    Set<CreatedMemberView> findAllCreatedMembers();
}