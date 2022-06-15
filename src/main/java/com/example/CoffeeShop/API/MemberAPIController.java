package com.example.CoffeeShop.API;

import com.example.CoffeeShop.DTO.MemberDto;
import com.example.CoffeeShop.Entity.Member;
import com.example.CoffeeShop.Service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
