package com.example.newshop.domain.member;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;

@Embeddable   //이 클래스는 값 타임을 정의하는 곳에 표시  복합값타입 클래스다
@Getter
public class  Address {
    private String city;        //요렇게 city,street,zipcode가 db에도 표시된다.
    private String street;
    private String zipcode;



}
