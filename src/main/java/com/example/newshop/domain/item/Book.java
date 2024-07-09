package com.example.newshop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK") //구분값을 BOOK으로설정
public class Book extends Item{
    private String author;
    private String isbn;
}
