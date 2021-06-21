package com.escalab.practice.vet.records;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VetRecordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetRecordsApplication.class, args);
	}

}
