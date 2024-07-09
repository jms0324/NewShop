package com.example.newshop.domain.member;


import com.example.newshop.domain.order.Order;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity//클래스위에 선언하여 이 클래스가 엔티티인것을 알려준다.
@Getter  //게터를 자동으로 작성해준다. 다른 클래스에서 이 클래스의 필드를 필요로할때 사용할 수 있다.
@AllArgsConstructor  //선언된 모든 필드를 갖는 생성자를 자동으로 만들어주는 어노테이션
@NoArgsConstructor   //파라미터가 아예없는 기본생성자를 자동으로 만들어주는 어노테이션
public class Member {

    @Id //이 엔티티의 주요키값 (primary key)을 지정해주는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk값을 어떻게 지정할 것인지 설정해주는 어노테이션
    @Column(name = "member_id")
    private Long id;



    @Embedded //복합값타입을 사용한다는 의미  주소에는 여러가지가 있고 이 정보들은 너무 상세하기 때문에 임베디드 타입을 사용
    private Address address;

    private String name;


    @OneToMany(mappedBy = "member") //일대다관계를 나타내주는 어노테이션 order가 연관관계의 주인
    private List<Order> orders;  //하나의 Member가 여러개의 Order를 가질 수 있다.

}
