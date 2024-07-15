package com.example.newshop.domain.item;


import com.example.newshop.exception.NotEnoughStockException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.Order;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
//세터제거
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //단일테이블전략 이 추상클래스를 상속받은 모든 클래스가 하나의 테이블에 저장됨
@DiscriminatorColumn(name = "DTYPE")//테이블의 각 행이 상속받은 자식클래스중 어떤 클래스인지 구분
public abstract class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;   //PK 주요키

    private String name;
    private int price;


    private int stockQuantity;

    public void addStock(int quantity){
        this.stockQuantity+=quantity;
    }

    public void removeStock(int quantity){
        int restStock=this.stockQuantity-quantity;
        if(restStock<0){
            throw new NotEnoughStockException("재고는 0이상이어야 합니다");
        }
        this.stockQuantity = restStock;
    }











}
