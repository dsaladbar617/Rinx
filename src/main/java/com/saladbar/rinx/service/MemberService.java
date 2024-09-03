package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> findAll();
    Member findById(int id);
    Member save(Member member);
    void delete(Member member);
}
