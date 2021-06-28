package com.escalab.practice.composer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.practice.composer.clients.PetsFeignClient;
import com.escalab.practice.composer.model.PetRecordDTO;

/**
 * The Class PetsServiceImpl.
 */
@Service
public class PetsServiceImpl implements PetsService  {

	/** The pets feign client. */
	@Autowired
	private PetsFeignClient petsFeignClient;
	

	/**
	 * Find pets.
	 *
	 * @param ownerRut the owner rut
	 * @return the list
	 */
	public List<PetRecordDTO> findPets(Long ownerRut) {
		return petsFeignClient.findPets(ownerRut);
	}
}
