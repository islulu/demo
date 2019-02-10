package com.alu.scaffold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.alu.scaffold")
public class ScaffoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaffoldApplication.class, args);
	}

}

