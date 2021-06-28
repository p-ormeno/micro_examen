package com.escalab.practice.composer.composer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.escalab.practice.composer.model.PetOwnerDTO;
import com.escalab.practice.composer.model.PetRecordDTO;
import com.escalab.practice.composer.service.OwnerService;
import com.escalab.practice.composer.service.PetsService;

/**
 * The Class VetComposer.
 */
@Component
public class VetComposer {
	
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private PetsService petsService;
	
	/**
	 * Gets the all pets by owners.
	 *
	 * @param rut the rut
	 * @return the all pets by owners
	 */
	public List<PetRecordDTO> getAllPetsByOwners(String rut) {
		PetOwnerDTO ownerDTO = ownerService.findOwner(rut);
		List<PetRecordDTO> listPets = petsService.findPets(Long.parseLong(ownerDTO.getRut()));

		return listPets;
	}

}
