package com.example.newshop.domain.item;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("ALBUM") //구분값을 앨범으로 설정
public class Album extends Item{

    private String artist;
    private String etc;



}
