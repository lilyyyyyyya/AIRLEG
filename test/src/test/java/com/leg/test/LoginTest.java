package com.leg.test;

//import static org.junit.Assert.*;
import com.leg.test.service.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTest {
    @Autowired
    private LoginService loginService;

    @Test
    void login(){
        String successResult = loginService.login(1,"123456");
        Assertions.assertEquals("success", successResult);

        String noIDResult = loginService.login(900000, "123456");
        Assertions.assertEquals("wrong password", noIDResult);

        String wrongPasswordResult = loginService.login(1, "222222");
        Assertions.assertEquals("wrong password", wrongPasswordResult);
    }

    @Test
    void register(){
        String existUserResult = loginService.register(1,"123456",30, "tianjin", "tianjin", "China");
        Assertions.assertEquals("error", existUserResult);
        String regResult = loginService.register(800000,"123456",30, "tianjin", "tianjin", "China");
        Assertions.assertEquals("success", regResult);
    }

}
