package com.example.CoffeeShop.Service;

import com.example.CoffeeShop.DTO.MemberDto;
import com.example.CoffeeShop.Entity.Member;
import com.example.CoffeeShop.Repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Member create(MemberDto dto) {
        Member member = dto.toEntity();
        if (member.getId() != null) {
            return null;
        }
        return memberRepository.save(member);
    }

    //회원 수정
    @Transactional
    public Member update(Long id, MemberDto dto) {
        Member member = dto.toEntity();
        log.info("id: {}, member: {}", id, member.toString());
        Member target = memberRepository.findById(id).orElse(null);
        if (target == null || id != member.getId()){
            log.info("잘못된 요청");
            return null;
        }
        target.patch(member);
        Member updated = memberRepository.save(target);
        return updated;
    }

    //회원 삭제
    @Transactional
    public Member delete(Long id) {
        Member target = memberRepository.findById(id).orElse(null);
        if (target == null) {
            return null;
        }
        memberRepository.delete(target);
        return target;
    }
}
