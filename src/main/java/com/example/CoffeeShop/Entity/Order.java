package com.example.CoffeeShop.Entity;

import com.example.CoffeeShop.DTO.OrderDto;
import com.example.CoffeeShop.Time.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
@Table(name = "Orders")
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @CreatedDate
    @Column
    private LocalDateTime orderDate;

    public static Order createOrder(OrderDto dto, Member member, Store store) {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("생성 실패, 주문에는 ID가 없어야 함.");
        }
//        if (dto.getMemberId() != member.getId()) {
//            throw new IllegalArgumentException("생성 실패, 회원의 ID가 다름");
//        }
        return new Order(
                dto.getId(),
                member,
                store,
                dto.getOrderDate()
        );
    }
}
