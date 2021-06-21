package com.escalab.practice.vet.owners.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class WeightDTO.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightDTO {

	/** The weight id. */
	private Long weightId;
	
	/** The insert date. */
	private Date insertDate;
		
	/** The weight. */
	private Float weight;
	
	/** The unit. */
	private String unit;
}
