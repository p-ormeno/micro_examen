package com.escalab.practice.composer.service;

import com.escalab.practice.composer.model.PetOwnerDTO;

/**
 * The Interface OwnerService.
 */
public interface OwnerService {

	/**
	 * Find owner.
	 *
	 * @param ownerRut the owner rut
	 * @return the pet owner DTO
	 */
	PetOwnerDTO findOwner(String ownerRut);

}
