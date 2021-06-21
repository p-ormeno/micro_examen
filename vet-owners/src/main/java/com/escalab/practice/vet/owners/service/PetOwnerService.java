package com.escalab.practice.vet.owners.service;

import org.springframework.http.ResponseEntity;

import com.escalab.practice.vet.owners.domain.PetOwnerDTO;
import com.escalab.practice.vet.owners.domain.request.OwnerRequest;

/**
 * The Interface PetOwnerService.
 */
public interface PetOwnerService {

	/**
	 * New owner.
	 *
	 * @param ownerRequest the owner request
	 * @return the response entity
	 */
	ResponseEntity<Object> saveOwner(OwnerRequest ownerRequest);

	/**
	 * Find owner.
	 *
	 * @param ownerRut the owner rut
	 * @return the pet owner DTO
	 */
	PetOwnerDTO findOwner(String ownerRut);

}
