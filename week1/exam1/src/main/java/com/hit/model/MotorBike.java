package com.hit.model;

import com.hit.interfaces.Vehicle;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("motorBike")
public class MotorBike implements Vehicle {

    @Override
    public void move() {
        System.out.println("MotorBike is moving");
    }
}
