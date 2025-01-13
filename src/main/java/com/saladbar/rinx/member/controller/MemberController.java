package com.saladbar.rinx.member.controller;

import com.saladbar.rinx.models.dto.CreatedMemberView;
import com.saladbar.rinx.models.entity.Goalie;
import com.saladbar.rinx.models.entity.Member;
import com.saladbar.rinx.models.entity.Skater;
import com.saladbar.rinx.goalie.service.GoalieService;
import com.saladbar.rinx.member.service.MemberService;
import com.saladbar.rinx.skater.service.SkaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;
    private final SkaterService skaterService;
    private final GoalieService goalieService;

    @Autowired
    public MemberController(MemberService memberService, SkaterService skaterService, GoalieService goalieService) {
        this.memberService = memberService;
        this.skaterService = skaterService;
        this.goalieService = goalieService;
    }

    @GetMapping("/members")
    public ResponseEntity<Set<CreatedMemberView>> hello() {

        Set<CreatedMemberView> members = memberService.findAllCreatedMembers();

        if (members.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(members);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<CreatedMemberView> getMember(@PathVariable long id) {

        CreatedMemberView member = memberService.findCreatedMember(id);

        if (member == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(member);
    }

    @PostMapping("/members")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        member.setDateJoined(Date.valueOf(LocalDate.now()));

        return ResponseEntity.ok(memberService.save(member));
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable long id) {
        Member member = memberService.findById(id);
        memberService.delete(member);
        return ResponseEntity.ok("Member deleted: " + member.getFirstName() + " " + member.getLastName());
    }

    @PostMapping("/members/{id}/skater")
    public ResponseEntity<Skater> addSkaterToMember(@PathVariable long id) {
        Skater skater = skaterService.addSkaterToMember(id);
        return ResponseEntity.ok(skater);
    }

    @PostMapping("/members/{id}/goalie")
    public ResponseEntity<Goalie> addGoalieToMember(@PathVariable long id) {
        Goalie goalie = goalieService.addGoalieToMember(id);
        return ResponseEntity.ok(goalie);
    }
}
