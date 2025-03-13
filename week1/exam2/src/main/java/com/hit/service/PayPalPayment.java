package com.hit.service;

import com.hit.interfaces.PaymentMethod;
import org.springframework.stereotype.Component;

@Component("paypal")
public class PayPalPayment implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("Thanh toán qua PayPal");
    }
}
