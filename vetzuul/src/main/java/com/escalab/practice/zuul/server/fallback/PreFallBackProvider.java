package com.escalab.practice.zuul.server.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import com.escalab.practice.zuul.server.reponse.GatewayClientResponse;
import com.netflix.hystrix.exception.HystrixTimeoutException;

/**
 * The Class PreFallBackProvider.
 */
@Configuration
public class PreFallBackProvider implements FallbackProvider {
	
	/** The Constant DEFAULT_MESSAGE. */
	private static final String DEFAULT_MESSAGE = "Servicio no disponible";

	@Override
	public String getRoute() {
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		if (cause instanceof HystrixTimeoutException) {
            return new GatewayClientResponse(HttpStatus.GATEWAY_TIMEOUT, DEFAULT_MESSAGE);
        } else {
            return new GatewayClientResponse(HttpStatus.INTERNAL_SERVER_ERROR, DEFAULT_MESSAGE);
        }
	}

}
