package com.example.CoffeeShop.Service;

import com.example.CoffeeShop.DTO.MemberDto;
import com.example.CoffeeShop.Entity.Member;
import com.example.CoffeeShop.Repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    //회원 조회
    public List<Member> list() {
        return memberRepository.findAll();
    }

    //회원 등록
    public Member create(MemberDto dto) {
        Member member = dto.toEntity();
        if (member.getId() != null) {
            return null;
        }
        return memberRepository.save(member);
    }
}
