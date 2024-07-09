package com.example.newshop.domain.item;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.Order;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //단일테이블전략 이 추상클래스를 상속받은 모든 클래스가 하나의 테이블에 저장됨
@DiscriminatorColumn(name = "DTYPE")//테이블의 각 행이 상속받은 자식클래스중 어떤 클래스인지 구분
public abstract class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;   //PK 주요키

    private String name;
    private int price;

    @Column(name ="stock_quantity")
    private int stockQuantitycategories;








}
