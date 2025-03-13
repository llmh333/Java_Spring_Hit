package com.hit.models;

import com.hit.interfaces.Order;
import com.hit.interfaces.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Customer {
    private Order order;
    private PaymentMethod paymentMethod;

    @Autowired
    public Customer(@Qualifier("healthyFood") Order order, @Qualifier("creditCard") PaymentMethod paymentMethod) {
        this.order = order;
        this.paymentMethod = paymentMethod;
    }

    public void orderFood() {
        order.placeOrder();
        paymentMethod.pay();
    }
}
