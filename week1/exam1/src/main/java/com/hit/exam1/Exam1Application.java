package com.hit.exam1;

import com.hit.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hit")
public class Exam1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Exam1Application.class, args);

		Person person = context.getBean(Person.class);
		person.noti();
	}
}
