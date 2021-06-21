package com.escalab.practice.vet.owners.domain.request;

import java.util.Date;

import lombok.Data;

/**
 * The Class OwnerRequest.
 */
@Data
public class OwnerRequest {

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

	/** The phone number 1. */
	private String phoneNumber1;

	/** The phone number 2. */
	private String phoneNumber2;

	/** The email. */
	private String email;

}
