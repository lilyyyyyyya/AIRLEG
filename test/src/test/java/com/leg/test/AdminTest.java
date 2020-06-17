package com.leg.test;

import com.leg.test.dao.MemberDao;
import com.leg.test.domain.po.Member;
import com.leg.test.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@SpringBootTest
class AdminTest {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberService memberService;

    @Test
    void contextLoads() {
        PageRequest pageRequest = PageRequest.of(0,7);
        Page<Member> page = memberDao.findAll(pageRequest);
        for(Member member:page){
            System.out.println(member);
        }
    }

    @Test
    void save(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String currentDate = date.format(formatter);
        String ffp_date = currentDate;
        Member member = new Member(500000, ffp_date, 0, 20, 0, "低价值客户", 0);
        Member member1 = memberDao.save(member);
        System.out.println(member1);
    }

    @Test
    void findById() {
        Member member = null;
        member = memberService.findById(700000);

        Member member1 = null;
        member1 = memberService.findById(100);
        System.out.println(member1);
    }

    @Test
    void update(){
        Member member = memberService.findById(2);
        member.setAGE(30);
        memberService.update(member);
    }

    @Test
    void delete(){
        memberService.deleteById(500000);
    }


}
