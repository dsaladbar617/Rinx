package com.saladbar.rinx.controller;

import com.saladbar.rinx.entity.Goalie;
import com.saladbar.rinx.entity.Member;
import com.saladbar.rinx.service.GoalieService;
import com.saladbar.rinx.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GoalieController {

    private final GoalieService goalieService;
    private final MemberService memberService;

    @Autowired
    public GoalieController(GoalieService goalieService, MemberService memberService) {
        this.goalieService = goalieService;
        this.memberService = memberService;
    }

    @GetMapping("/goalies")
    public List<Goalie> getGoalies() {
        return goalieService.findAll();
    }

    @PostMapping("/goalies/{memberId}")
    public Goalie addGoalie( @PathVariable int memberId) {
        Member member = memberService.findById(memberId);
        Goalie goalie = goalieService.save(new Goalie());
        member.setGoalie(goalie);
        memberService.save(member);
        return goalie;
    }
}
