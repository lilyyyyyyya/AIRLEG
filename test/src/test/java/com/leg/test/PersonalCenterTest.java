package com.leg.test;

import com.leg.test.domain.po.Personal;
import com.leg.test.service.PersonalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonalCenterTest {
    @Autowired
    private PersonalService personalService;

    @Test
    void personalInformation(){
        //显示个人信息
        Personal info = personalService.findById(1);
        System.out.println(info);
    }

    @Test
    void updateInformation(){
        Personal personal = personalService.findById(1);
        personal.setWork_city("天津");
        personalService.update(personal);
    }

    @Test
    void changePassword(){
        String successResult = personalService.updatePassword(1,"123456", "222222");
        Assertions.assertEquals("success", successResult);
        String wrongPasswordResult = personalService.updatePassword(2, "222222", "1111111");
        Assertions.assertEquals("wrong password", wrongPasswordResult);
    }
}
