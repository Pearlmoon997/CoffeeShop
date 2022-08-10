//package com.example.CoffeeShop.Time;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@SpringBootTest
//class TimeTestEntityTest {
//
//    @Autowired
//    TimeTestRepository timeTestRepository;
//
//    @Test
//    @DisplayName("BaseTimeEntity_테스트")
//    public void TimeTest() {
//        LocalDateTime now = LocalDateTime.now(); //로컬 컴퓨터의 현재 날짜와 시간정보를 now 변수에 저장
//        timeTestRepository.save(new TimeTestEntity());
//
//        List<TimeTestEntity> times = timeTestRepository.findAll();
//
//        TimeTestEntity time = times.get(0);
//
//        System.out.println("Create Date = " + time.getCreatedDate());
//        System.out.println("Modified Date = " + time.getModifiedDate());
//
//        assertThat(time.getCreatedDate()).isAfter(now);
//        assertThat(time.getModifiedDate()).isAfter(now);
//    }
//
//}