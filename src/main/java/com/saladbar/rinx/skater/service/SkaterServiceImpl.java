package com.saladbar.rinx.skater.service;

import com.saladbar.rinx.models.entity.Member;
import com.saladbar.rinx.models.entity.Skater;
import com.saladbar.rinx.member.service.MemberService;
import com.saladbar.rinx.skater.repository.SkaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("Skater")
public class SkaterServiceImpl implements SkaterService {

    private final SkaterRepository skaterRepository;
    private final MemberService memberService;

    @Autowired
    public SkaterServiceImpl(SkaterRepository skaterRepository, MemberService memberService) {
        this.skaterRepository = skaterRepository;
        this.memberService = memberService;
    }

    @Override
    public List<Skater> findAll() {
        return skaterRepository.findAll();
    }

    @Override
    public Skater findById(long id) {
        return skaterRepository.findById(id).orElse(null);
    }

    @Override
    public Skater save(Skater skater) {
        return skaterRepository.save(skater);
    }

    @Override
    public void delete(Skater skater) {
        skaterRepository.delete(skater);
    }

    @Override
    public Skater addSkaterToMember(long id) {
        Member member = memberService.findById(id);
        Skater skater = new Skater(member);
        return skaterRepository.save(skater);
    }


}
