package com.escalab.practice.vet.owners.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;


/**
 * The Class EurekaClient.
 */
@Component("EurekaClient")
public class EurekaClient {
	
	/** The discovery client. */
	@Autowired
	private DiscoveryClient discoveryClient;
	
	/**
	 * Gets the uri.
	 *
	 * @param serviceName the service name
	 * @return the uri
	 */
	public URI getUri(String serviceName) {
		List<ServiceInstance> servList = discoveryClient.getInstances(serviceName);
		
		if(servList != null && !servList.isEmpty()) {
			return servList.get(0).getUri();
		}
		
		return null;	
	}

}
