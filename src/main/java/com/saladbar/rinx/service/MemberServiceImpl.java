package com.saladbar.rinx.service;

import com.saladbar.rinx.dto.CreatedMemberView;
import com.saladbar.rinx.repository.MemberRepository;
import com.saladbar.rinx.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member.orElse(null);
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void delete(Member member) {
        memberRepository.delete(member);
    }

    @Override
    public CreatedMemberView findCreatedMember(long id) {
        return memberRepository.findByMemberId(id);
    }

    @Override
    public Set<CreatedMemberView> findAllCreatedMembers() {
        return memberRepository.findAllBy();
    }


}
