package com.example.CoffeeShop.API;

import com.example.CoffeeShop.DTO.MemberDto;
import com.example.CoffeeShop.Entity.Member;
import com.example.CoffeeShop.Service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class MemberAPIController {

    @Autowired
    private MemberService memberService;

    //모든 회원 조회
    @GetMapping("/api/members")
    public List<Member> list() {
        return memberService.list();
    }

    //회원 등록
    @PostMapping("/api/members")
    public ResponseEntity<Member> create(@RequestBody MemberDto dto) {
        Member created = memberService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //회원 수정
    @PatchMapping("/api/members/{id}")
    public ResponseEntity<Member> update(@PathVariable Long id, @RequestBody MemberDto dto) {
        Member updated = memberService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //회원 삭제
    @DeleteMapping("/api/members/{id}")
    public ResponseEntity<Member> delete(@PathVariable Long id) {
        Member deleted = memberService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
