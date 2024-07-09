package com.example.newshop.domain.item;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MOVIE")//구분값을 무비로 설정
public class Movie extends Item{
    private String director;
    private String actor;
}
