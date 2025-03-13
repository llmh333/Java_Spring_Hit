package com.hit.service;

import com.hit.interfaces.Order;
import org.springframework.stereotype.Component;

@Component("fastFood")
public class FastFoodOrder implements Order {
    @Override
    public void placeOrder() {
        System.out.println("Đặt món ăn nhanh");
    }
}
