package com.escalab.practice.vet.owners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.escalab.practice.vet.owners.config.RibbonConfig;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "restTemplate", configuration = {RibbonConfig.class})
@EnableCircuitBreaker
public class VetOwnersApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetOwnersApplication.class, args);
	}

}
