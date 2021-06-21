package com.escalab.practice.vet.owners.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.escalab.practice.vet.owners.domain.PetOwnerDTO;
import com.escalab.practice.vet.owners.domain.request.OwnerRequest;
import com.escalab.practice.vet.owners.jpa.model.PetOwnerEntity;
import com.escalab.practice.vet.owners.jpa.repository.PetOwnerJpaRepository;
import com.escalab.practice.vet.owners.service.PetOwnerService;
import com.escalab.practice.vet.owners.utils.Utils;

/**
 * The Class PetOwnerServiceImpl.
 */
@Service
public class PetOwnerServiceImpl implements PetOwnerService{

	@Autowired
	private PetOwnerJpaRepository ownerRepository;
	
	
	/**
	 * New owner.
	 *
	 * @param ownerRequest the owner request
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Object> saveOwner(OwnerRequest ownerRequest) {
		ResponseEntity<Object> response = null;

		PetOwnerEntity newOwner = Utils.getOwnerFromRequest(ownerRequest);
		PetOwnerDTO owner = this.findOwner(ownerRequest.getRut());

		// If we found an owner, we keep ID and InsertDate and update with every value
		// from request
		if (owner != null) {
			newOwner.setOwnerId(owner.getOwnerId());
			newOwner.setInsertDate(owner.getInsertDate());
		}

		newOwner = ownerRepository.save(newOwner);

		if (newOwner.getOwnerId() != null) {
			response = new ResponseEntity<>("OK", HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<>("NOK", HttpStatus.NO_CONTENT);
		}

		return response;
	}

	/**
	 * Find owner.
	 *
	 * @param ownerRut the owner rut
	 * @return the pet owner DTO
	 */
	@Override
	public PetOwnerDTO findOwner(String ownerRut) {
		PetOwnerEntity owner = ownerRepository.findOwnerByRut(ownerRut);
		if (owner != null) {
			return Utils.getPetOwnerDTO(owner);
		} else {
			return null;
		}
	}

}
