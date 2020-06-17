package com.leg.test;

import com.leg.test.service.DiscountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DiscountTest {
    @Autowired
    private DiscountService discountService;

    @Test
    void discount(){
        Integer discount1 = discountService.findDiscount(6);
        Assertions.assertEquals(95, discount1);
        Integer discount2 = discountService.findDiscount(1);
        Assertions.assertEquals(90, discount2);
        Integer discount3 = discountService.findDiscount(7);
        Assertions.assertEquals(85, discount3);
        Integer discount4 = discountService.findDiscount(5);
        Assertions.assertEquals(80, discount4);
        Integer discount5 = discountService.findDiscount(10);
        Assertions.assertEquals(75, discount5);
    }
}
