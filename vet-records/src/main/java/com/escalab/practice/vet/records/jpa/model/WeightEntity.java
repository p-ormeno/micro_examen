package com.escalab.practice.vet.records.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class WeightEntity.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "WEIGHT_LOG")
public class WeightEntity {

	/** The weight id. */
	@Id
	@Column(name ="WEIGHT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private Long weightId;
	
	/** The insert date. */
	@Column(name="INSERT_DATE")
	private Date insertDate;
	
	/** The pet. */
	@ManyToOne
    @JoinColumn(name="PET_ID", nullable=false)
	private PetEntity pet;
	
	/** The weight. */
	@Column(name="WEIGHT_VALUE")
	private Float weight;
	
	/** The unit. */
	@Column(name="WEIGHT_UNIT")
	private String unit;
	
}
