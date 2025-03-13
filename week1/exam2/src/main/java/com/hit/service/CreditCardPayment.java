package com.hit.service;

import com.hit.interfaces.PaymentMethod;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("creditCard")
@Primary
public class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Thanh toán bằng thẻ tín dụng");
    }
}
