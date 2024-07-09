package com.example.newshop.domain.member.repository;


import com.example.newshop.domain.member.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository  //이 클래스는 레포지토리다 스프링 빈으로 등록
public class MemberRepository {

    @PersistenceContext //
    EntityManager em;  //엔티티매니저는 JPA에서 제공하는 핵심 인터페이스로, 데이터베이스와 스프링사이에 중개상 역할을 해준다!
                       //자바 객체(@Entity)를 DB에 저장된 데이터와 매핑시켜준다. ORM기술
    public Long save(Member member){

        em.persist(member);     //아까 중개상 역할을 해준다했는데, 이렇게 엔티티매니저의 persist메서드를 쓰면 db에 저장된다.

        return member.getId(); // 여기에 쓸라고 아까 Member엔티티에 게터어노테이션 붙인거임

    }

    public Member find(Long memberId){
        return em.find(Member.class,memberId);  //아까 중개상 역할을 해준다했는데, 이렇게 엔티티매니저의 find메서드를 쓰면
                                                //db에서 해당하는 id값을 가진 클래스의 객체를 찾아서 반환해준다.
    }

}
