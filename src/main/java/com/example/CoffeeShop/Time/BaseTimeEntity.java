package com.example.CoffeeShop.Time;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // JPA Entity 클래스들이 상속받을 경우 필드도 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) //Auditing 기능 추가
@Getter //Getter 추가, 롬복
public class BaseTimeEntity {

    @CreatedDate //생성 시간
    private LocalDateTime createdDate;

    @LastModifiedDate //수정 시간
    private LocalDateTime modifiedDate;
}
