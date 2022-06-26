package br.com.meli;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.meli.controller.URLController;

@SpringBootApplication
public class MongApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongApiApplication.class, args);
	}

}
