package com.escalab.practice.vet.owners.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.escalab.practice.vet.owners.domain.PetOwnerDTO;
import com.escalab.practice.vet.owners.domain.PetRecordDTO;
import com.escalab.practice.vet.owners.domain.request.OwnerRequest;
import com.escalab.practice.vet.owners.service.PetOwnerService;
import com.escalab.practice.vet.owners.utils.Urls;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * The Class PetOwnerController.
 */
@CrossOrigin
@RestController
@RequestMapping(value = Urls.PET_OWNER)
public class PetOwnerController {

	/** The owner service. */
	@Autowired
	private PetOwnerService ownerService;
	
	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Add a new pet owner.
	 *
	 * @param ownerRequest the owner request
	 * @return the response entity
	 */
	@PostMapping(path = Urls.NEW_OWNER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> newOwner(@RequestBody OwnerRequest ownerRequest) {
		return ownerService.saveOwner(ownerRequest);
	}
	
	/**
	 * Update owner.
	 *
	 * @param ownerRequest the owner request
	 * @return the response entity
	 */
	@PostMapping(path = Urls.UPDATE_OWNER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> updateOwner(@RequestBody OwnerRequest ownerRequest) {
		return ownerService.saveOwner(ownerRequest);
	}
	
	
	/**
	 * Find owner.
	 *
	 * @param ownerRut the owner rut
	 * @return the pet owner DTO
	 */
	@GetMapping(path = Urls.FIND_OWNER)
	public @ResponseBody PetOwnerDTO findOwner(@PathVariable String ownerRut) {
		return ownerService.findOwner(ownerRut);
	}
	
	/**
	 * Gets the pets.
	 *
	 * @param ownerRut the owner rut
	 * @return the pets
	 */
	@HystrixCommand(fallbackMethod="emptyReturn", commandProperties= {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "8"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "25")
	})
	@GetMapping(path = Urls.PET_BY_OWNER)
	public List<PetRecordDTO> getPets(@PathVariable Long ownerRut) {

		List<PetRecordDTO> recordDto = (List<PetRecordDTO>) restTemplate
				.getForObject("http://vet.user/"+ Urls.PET_RECORD + Urls.PET_BY_OWNER + ownerRut, PetRecordDTO.class);
		return recordDto;
	}
	
	/**
	 * Empty return.
	 *
	 * @param ownerRut the owner rut
	 * @return the list
	 */
	public List<PetRecordDTO> emptyReturn(Long ownerRut){
		return new ArrayList<PetRecordDTO>();
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	    return builder.build();
	}
}
