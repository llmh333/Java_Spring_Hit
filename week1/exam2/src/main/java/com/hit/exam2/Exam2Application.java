package com.hit.exam2;

import com.hit.models.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hit")
public class Exam2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Exam2Application.class, args);

		Customer customer = context.getBean(Customer.class);

		customer.orderFood();
	}

}
