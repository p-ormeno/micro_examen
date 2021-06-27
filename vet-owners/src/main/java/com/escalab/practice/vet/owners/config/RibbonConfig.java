package com.escalab.practice.vet.owners.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class RibbonConfig {
	
	@Bean
	public IRule ribbonRule() {
		return new RetryRule(new BestAvailableRule(), 500);
	}

}
