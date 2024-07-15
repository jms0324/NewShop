package com.example.newshop.domain.order;


import com.example.newshop.domain.delivery.Delivery;
import com.example.newshop.domain.member.Member;
import com.example.newshop.domain.orderitem.OrderItem;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)//다대일 관계
    @JoinColumn(name = "member_id") // 칼럼이름을 member_id로지정
    private Member member;

    /*@OneToMany
    private List<OrderItems> orderItems;*/

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL) //지연로딩, 주문과 배달의 관계는 일대일
    @JoinColumn(name ="delivery_id")  //외래키로 설정 해당 필드의 타입의 pk로 fk이름이 지정된다 연관관계의 주인이 member이다
    private Delivery delivery;


    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)  //오더아이템의 order필드에 매핑되어있다
    private List<OrderItem> orderItems=new ArrayList<>();

    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}
