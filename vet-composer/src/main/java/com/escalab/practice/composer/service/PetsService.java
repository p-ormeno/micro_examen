package com.escalab.practice.composer.service;

import java.util.List;

import com.escalab.practice.composer.model.PetRecordDTO;

/**
 * The Interface PetsService.
 */
public interface PetsService {

	/**
	 * Find pets.
	 *
	 * @param ownerRut the owner rut
	 * @return the list
	 */
	List<PetRecordDTO> findPets(Long ownerRut);
}
