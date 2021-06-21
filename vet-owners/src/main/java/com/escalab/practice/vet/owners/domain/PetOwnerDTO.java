package com.escalab.practice.vet.owners.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class PetOwnerDTO.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetOwnerDTO {

	/** The owner id. */
	private Long ownerId;

	/** The insert date. */
	private Date insertDate;

	/** The rut. */
	private String rut;

	/** The owner name. */
	private String ownerName;

	/** The owner surame. */
	private String ownerSurname;

	/** The address. */
	private String address;

	private String phoneNumber1;

	/** The phone number 2. */
	private String phoneNumber2;

	/** The email. */
	private String email;

}
