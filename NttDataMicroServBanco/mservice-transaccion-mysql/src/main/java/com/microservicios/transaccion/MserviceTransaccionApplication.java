package com.microservicios.transaccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MserviceTransaccionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MserviceTransaccionApplication.class, args);
	}

}
