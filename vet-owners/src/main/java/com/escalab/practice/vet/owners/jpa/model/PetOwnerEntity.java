package com.escalab.practice.vet.owners.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class PetOwnerEntity.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "PET_OWNER")
public class PetOwnerEntity {

	/** The owner id. */
	@Id
	@Column(name ="OWNER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ownerId;
	
	/** The insert date. */
	@Column(name="INSERT_DATE")
	private Date insertDate;
	
	/** The rut. */
	@Column(name="OWNER_RUT", nullable=false)
	private String rut;
	
	/** The owner name. */
	@Column(name="OWNER_NAME")
	private String ownerName;
	
	/** The owner surame. */
	@Column(name="OWNER_SURNAME")
	private String ownerSurname;
	
	/** The address. */
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="PHONE_NUMBER1", nullable=false)
	private String phoneNumber1;
	
	/** The phone number 2. */
	@Column(name="PHONE_NUMBER2")
	private String phoneNumber2;
	
	/** The email. */
	@Column(name="OWNER_EMAIL")
	private String email;
	
}
