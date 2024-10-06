package com.nttdata.mservice_transaccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MserviceTransaccionMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MserviceTransaccionMongodbApplication.class, args);
	}

}
