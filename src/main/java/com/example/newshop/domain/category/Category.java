package com.example.newshop.domain.category;

import com.example.newshop.domain.item.Item;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany  //다대다 연결을 위한 중간테이블
    @JoinTable(name = "category_item",
               joinColumns = @JoinColumn(name="category_id"), //자식엔티티가 부모엔티티의 기본키를 참조하는
               inverseJoinColumns = @JoinColumn(name = "item_id"))//다른엔티티의 기본키(item)을 참조
    private List<Item> items = new ArrayList<>();


    //동일한 엔티티에 관해서 셀프로 연관관계를 생성했다 == 상속
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;


    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //연관관계편의 메서드
    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }

}
