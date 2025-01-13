package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.Goalie;
import com.saladbar.rinx.entity.Member;
import com.saladbar.rinx.repository.GoalieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("Goalie")
public class GoalieServiceImpl implements GoalieService{

    private final GoalieRepository goalieRepository;
    private final MemberService memberService;

    @Autowired
    public GoalieServiceImpl(GoalieRepository goalieRepository, MemberService memberService) {
        this.goalieRepository = goalieRepository;
        this.memberService = memberService;
    }

    @Override
    public List<Goalie> findAll() {
        return goalieRepository.findAll();
    }

    @Override
    public Goalie findById(long id) {
        return goalieRepository.findById(id).orElse(null);
    }

    @Override
    public Goalie save(Goalie goalie) {
        return goalieRepository.save(goalie);
    }

    @Override
    public void delete(Goalie goalie) {
        goalieRepository.delete(goalie);
    }

    @Override
    public Goalie addGoalieToMember(long id) {
        Member member = memberService.findById(id);
        Goalie goalie = new Goalie(member);
        return goalieRepository.save(goalie);
    }
}
