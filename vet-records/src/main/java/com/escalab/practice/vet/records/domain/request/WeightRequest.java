package com.escalab.practice.vet.records.domain.request;

import lombok.Data;

/**
 * The Class WeightRequest.
 */
@Data
public class WeightRequest {
	
	/** The pet id. */
	private Long petId;
	
	/** The weight. */
	private Float weight;
	
	/** The unit. */
	private String unit;

}
