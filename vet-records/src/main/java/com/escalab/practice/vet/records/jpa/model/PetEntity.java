package com.escalab.practice.vet.records.jpa.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class PetEntity.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "PET_RECORD")
public class PetEntity {
	
	/** The pet id. */
	@Id
	@Column(name ="PET_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private Long petId;
	
	/** The insert date. */
	@Column(name="INSERT_DATE")
	private Date insertDate;
	
	/** The owner. */
	@Column(name="OWNER_ID", nullable=false)
	private Long owner;
	
	/** The name. */
	@Column(name="NAME")
	private String name;
	
	/** The sex type. */
	@Column(name="SEX_TYPE")
	private String sexType;
	
	/** The species. */
	@Column(name="SPECIES")
	private String species;
	
	/** The race. */
	@Column(name="RACE")
	private String race;
	
	/** The weight. */
	@OneToMany(mappedBy="pet")
	private Set<WeightEntity> weight;
	
	/** The birth day. */
	@Column(name="BIRTH_DATE", nullable=false)
	private Date  birthDay;
	
	/** The death day. */
	@Column(name="DEATH_DATE")
	private Date deathDay;
	
	/** The color. */
	@Column(name="COLOR")
	private String color;
	
	/** The is donor. */
	@Column(name="DONOR")
	private Boolean isDonor;
	
	/** The is neutered. */
	@Column(name="NEUTERED")
	private Boolean isNeutered;
	
	/** The chip id. */
	@Column(name="CHIP_ID")
	private String chipId;
	
	/** The chip numbert EXT. */
	@Column(name="CHIP_NUMBER")
	private String chipNumbertEXT;
	
	/** The blood type. */
	@Column(name="BLOOD_TYPE")
	private String bloodType;	
	
}
