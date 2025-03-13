package com.hit.model;

import com.hit.interfaces.Engine;
import org.springframework.stereotype.Component;

@Component("GasolineEngine")
public class GasolineEngine implements Engine {
    @Override
    public void active() {
        System.out.println("GasolineEngine is active");
    }
}
