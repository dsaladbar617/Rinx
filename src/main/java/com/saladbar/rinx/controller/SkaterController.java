package com.saladbar.rinx.controller;

import com.saladbar.rinx.entity.Member;
import com.saladbar.rinx.entity.Skater;
import com.saladbar.rinx.service.MemberService;
import com.saladbar.rinx.service.SkaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SkaterController {

//    @Qualifier("Skater")
    private final SkaterService skaterService;
    private final MemberService memberService;

    @Autowired
    public SkaterController(SkaterService skaterService, MemberService memberService) {
        this.skaterService = skaterService;
        this.memberService = memberService;
    }

    @GetMapping("/skaters")
    public List<Skater> getSkaters() {
        return skaterService.findAll();
    }

    @PostMapping("/skaters/{memberId}")
    public ResponseEntity<Skater> addSkater(@PathVariable int memberId) {

        Member member = memberService.findById(memberId);
        Skater skater = skaterService.save(new Skater());
        member.setSkater(skater);
        memberService.save(member);
        return ResponseEntity.ok(skater);
    }

    @DeleteMapping("/skaters/{skaterId}")
    public ResponseEntity<String> removeSkater(@PathVariable int skaterId) {
        Skater skater = skaterService.findById(skaterId);
        skaterService.delete(skater);
        return ResponseEntity.ok("Deleted skater: " + skaterId);
    }
}
