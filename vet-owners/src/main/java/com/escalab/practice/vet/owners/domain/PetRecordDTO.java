package com.escalab.practice.vet.owners.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class PetRecordDTO.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetRecordDTO {

	/** The pet id. */
	private Long petId;

	/** The insert date. */
	private Date insertDate;

	/** The name. */
	private String name;

	/** The sex type. */
	private String sexType;

	/** The species. */
	private String species;

	/** The race. */
	private String race;

	/** The weight. */
	private List<WeightDTO> weight;

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

}
