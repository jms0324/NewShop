package com.example.newshop.domain.delivery;

import com.example.newshop.domain.member.Address;
import com.example.newshop.domain.order.Order;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id") //칼럼의 이름을 delivery_id로 지정
    private Long id;

    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY) //딜리버리테이블에서는 멤버의 외래키 x 그러므로 연관관계의 주인을 멤버로 설정
    private Order order;   //조인칼럼x db예시사진을 보면  delivery측에선 order_id필드가없다.

    @Embedded //Address클래스는 복합값타입이므로 복합값타입을 사용하겠다는 의미의 어노테이션을 붙임
    private Address address;

    private DeliveryStatus status;


}
