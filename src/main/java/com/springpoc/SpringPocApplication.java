package com.springpoc;

import com.springpoc.controller.JfaxController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan("com.springpoc")
@ComponentScan(basePackageClasses = JfaxController.class)
public class SpringPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPocApplication.class, args);
	}

}
