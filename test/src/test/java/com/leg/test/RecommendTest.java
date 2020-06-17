package com.leg.test;

import com.leg.test.domain.po.Place;
import com.leg.test.domain.po.Product;
import com.leg.test.service.PlaceService;
import com.leg.test.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RecommendTest {
    @Autowired
    private PlaceService placeService;
    @Autowired
    private ProductService productService;

    @Test
    //商品推荐
    void getProduct(){
        //低价值客户
        List<Product> product1 = productService.findCluster(6);
        System.out.println(product1);
        //一般客户
        List<Product> product2 = productService.findCluster(1);
        System.out.println(product2);
        //重要挽留客户
        List<Product> product3 = productService.findCluster(7);
        System.out.println(product3);
        //重要发展客户
        List<Product> product4 = productService.findCluster(5);
        System.out.println(product4);
        //重要保持客户
        List<Product> product5 = productService.findCluster(10);
        System.out.println(product5);
    }

    @Test
    //地点推荐
    void getPlace(){
        List<Place> places = placeService.findAll();
        System.out.println(places);
    }
}
