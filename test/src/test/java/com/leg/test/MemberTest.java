package com.leg.test;

import com.leg.test.domain.po.ExchangePoints;
import com.leg.test.domain.po.MemberPoints;
import com.leg.test.domain.po.MileageUpgrade;
import com.leg.test.service.ExchangePointsService;
import com.leg.test.service.MemberPointsService;
import com.leg.test.service.MileageUpgradeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MemberTest {
    @Autowired
    private MemberPointsService memberPointsService;
    @Autowired
    private ExchangePointsService exchangePointsService;
    @Autowired
    private MileageUpgradeService mileageUpgradeService;

    @Test
    //积分明细
    void getPoints(){
        MemberPoints points = memberPointsService.getPoints(1);
        System.out.println(points);
    }

    @Test
    //积分兑换
    void exchangeFlight(){
        List<ExchangePoints> result_flight = exchangePointsService.getFlightInformation("北京", "上海", "2020-05-04");
        ExchangePoints flight = result_flight.get(0);
        String notEnoughPointsResult = exchangePointsService.deductPoints(1, flight.getPoints_need());
        Assertions.assertEquals("error", notEnoughPointsResult);
        String successResult = exchangePointsService.deductPoints(2, flight.getPoints_need());
        Assertions.assertEquals("success", successResult);
    }

    @Test
    //里程升舱
    void mileageUpgrade(){
        List<MileageUpgrade> result_flight = mileageUpgradeService.getFlightInformation("CZ9378");
        MileageUpgrade flight = result_flight.get(0);
        String notEnoughMileageResult = mileageUpgradeService.upgradeMileage(5, flight.getMileage());
        Assertions.assertEquals("error", notEnoughMileageResult);
        String successResult = mileageUpgradeService.upgradeMileage(1, flight.getMileage());
        Assertions.assertEquals("success", successResult);
    }
}
