package com.escalab.practice.vet.records.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.escalab.practice.vet.records.domain.PetRecordDTO;
import com.escalab.practice.vet.records.domain.WeightDTO;
import com.escalab.practice.vet.records.domain.request.PetRequest;
import com.escalab.practice.vet.records.domain.request.WeightRequest;

/**
 * The Interface PetRecordService.
 */
public interface PetRecordService {

	/**
	 * Adds the new pet.
	 *
	 * @param petRequest the pet request
	 * @return the response entity
	 */
	ResponseEntity<Object> addNewPet(PetRequest petRequest);
	
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	List<PetRecordDTO> findByName(String name);
	
	/**
	 * Find by pets by owner.
	 *
	 * @param ownerRut the owner rut
	 * @return the list
	 */
	List<PetRecordDTO> findByOwner(Long ownerRut);


	/**
	 * Update pet.
	 *
	 * @param petRequest the pet request
	 * @return the response entity
	 */
	ResponseEntity<Object> updatePet(PetRequest petRequest);


	/**
	 * Adds the weight.
	 *
	 * @param weightRequest the weight request
	 * @return the response entity
	 */
	ResponseEntity<Object> addWeight(WeightRequest weightRequest);


	/**
	 * Gets the weight log.
	 *
	 * @param petID the pet ID
	 * @return the weight log
	 */
	List<WeightDTO> getWeightLog(Long petID);

}
