package com.hit.model;

import com.hit.interfaces.Engine;
import org.springframework.stereotype.Component;

@Component("electricEngine")
public class ElectricEngine implements Engine {
    @Override
    public void active() {
        System.out.println("ElectricEngine is active");
    }
}
