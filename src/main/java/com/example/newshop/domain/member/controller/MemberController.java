package com.example.newshop.domain.member.controller;



import com.example.newshop.domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    @Autowired  //의존성주입
    private MemberRepository memberRepository;



}
