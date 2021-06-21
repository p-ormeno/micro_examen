package com.escalab.practice.vet.records.domain.request;

import java.util.Date;

import lombok.Data;

/**
 * The Class PetRequest.
 */
@Data
public class PetRequest {

	/** The pet id. */
	private Long petId;
	
	/** The name. */
	private String name;

	/** The sex type. */
	private String sexType;

	/** The species. */
	private String species;

	/** The race. */
	private String race;

	/** The weight. */
	private Float weight;
	
	/** The weight unit. */
	private String weightUnit;

	/** The birth day. */
	private Date birthDay;

	/** The death day. */
	private Date deathDay;

	/** The color. */
	private String color;

	/** The is donor. */
	private Boolean isDonor;

	/** The is neutered. */
	private Boolean isNeutered;

	/** The chip id. */
	private String chipId;

	/** The chip numbert EXT. */
	private String chipNumbertEXT;

	/** The blood type. */
	private String bloodType;
	
	/** The owner ID. */
	private Long ownerID;
}
