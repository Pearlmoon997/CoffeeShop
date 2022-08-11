package com.example.CoffeeShop.Service;

import com.example.CoffeeShop.DTO.UserDto;
import com.example.CoffeeShop.Entity.User;
import com.example.CoffeeShop.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //회원 조회
    public List<User> list() {
        return userRepository.findAll();
    }

    //회원 등록
    @Transactional
    public User create(UserDto dto) {
        User member = dto.toEntity();
        if (member.getId() != null) {
            return null;
        }
        return userRepository.save(member);
    }

    //회원 수정
    @Transactional
    public User update(Long id, UserDto dto) {
        User user = dto.toEntity();
        log.info("id: {}, member: {}", id, user.toString());
        User target = userRepository.findById(id).orElse(null);
        if (target == null || id != user.getId()){
            log.info("잘못된 요청");
            return null;
        }
        target.patch(user);
        User updated = userRepository.save(target);
        return updated;
    }

    //회원 삭제
    @Transactional
    public User delete(Long id) {
        User target = userRepository.findById(id).orElse(null);
        if (target == null) {
            return null;
        }
        userRepository.delete(target);
        return target;
    }
}
