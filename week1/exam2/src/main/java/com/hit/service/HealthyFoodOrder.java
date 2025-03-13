package com.hit.service;

import com.hit.interfaces.Order;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("healthyFood")
public class HealthyFoodOrder implements Order {
    @Override
    public void placeOrder() {
        System.out.println("Đặt món ăn lành mạnh");
    }
}
