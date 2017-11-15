package com.greenfox.salankiv.p2pchat;

import com.greenfox.salankiv.p2pchat.model.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class P2pchatApplication {

	public static void main(String[] args) {
		SpringApplication.run(P2pchatApplication.class, args);
	}
}
