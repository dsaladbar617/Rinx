package com.saladbar.rinx.controller;

import com.saladbar.rinx.entity.Member;
import com.saladbar.rinx.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> hello() {
        List<Member> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getMember(@PathVariable int id) {
        return ResponseEntity.ok(memberService.findById(id));
    }

    @PostMapping("/members")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.save(member));
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable int id) {
        Member member = memberService.findById(id);
        memberService.delete(member);
        return ResponseEntity.ok("Member deleted: " + member.getFirstName() + " " + member.getLastName());
    }
}
