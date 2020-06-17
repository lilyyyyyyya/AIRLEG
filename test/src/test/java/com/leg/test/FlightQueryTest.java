package com.leg.test;

import com.leg.test.domain.po.Flight;
import com.leg.test.service.FlightQueryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FlightQueryTest {
    @Autowired
    private FlightQueryService flightQueryService;

    @Test
    void findFlight(){
        Flight successResult = flightQueryService.findByFlight_noAndDate("CZ9378", "2020-05-04");
        System.out.println(successResult);
        Flight errorResult = flightQueryService.findByFlight_noAndDate("CA9378", "2019-05-04");
        System.out.println(errorResult);
    }
}
