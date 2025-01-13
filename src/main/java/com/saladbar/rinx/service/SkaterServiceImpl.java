package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.Member;
import com.saladbar.rinx.entity.Skater;
import com.saladbar.rinx.entity.Team;
import com.saladbar.rinx.repository.SkaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
