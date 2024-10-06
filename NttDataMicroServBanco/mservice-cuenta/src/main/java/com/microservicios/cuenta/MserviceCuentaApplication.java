package com.microservicios.cuenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MserviceCuentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MserviceCuentaApplication.class, args);
	}

}
