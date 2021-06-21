package com.escalab.practice.vet.owners.utils;

import java.util.Date;

import com.escalab.practice.vet.owners.domain.PetOwnerDTO;
import com.escalab.practice.vet.owners.domain.request.OwnerRequest;
import com.escalab.practice.vet.owners.jpa.model.PetOwnerEntity;

/**
 * The Class Utils.
 */
public class Utils {
	
	
	// DTOS

	/**
	 * Gets the pet owner DTO.
	 *
	 * @param ownerEntity the owner entity
	 * @return the pet owner DTO
	 */
	public static PetOwnerDTO getPetOwnerDTO(PetOwnerEntity ownerEntity) {
		PetOwnerDTO dto = null;
        if (ownerEntity != null) {
            dto = new PetOwnerDTO();

            dto.setOwnerId(ownerEntity.getOwnerId());
            dto.setInsertDate(ownerEntity.getInsertDate());
            dto.setOwnerName(ownerEntity.getOwnerName());
            dto.setOwnerSurname(ownerEntity.getOwnerSurname());
            dto.setPhoneNumber1(ownerEntity.getPhoneNumber1());
            dto.setPhoneNumber2(ownerEntity.getPhoneNumber2());
            dto.setAddress(ownerEntity.getAddress());
            dto.setEmail(ownerEntity.getEmail());
            dto.setRut(ownerEntity.getRut());
            
        }
        return dto;
    }
	
	// ENTITIES

	
	// OTHERS


	
	/**
	 * Gets the owner from request.
	 *
	 * @param ownerRequest the owner request
	 * @return the owner from request
	 */
	public static PetOwnerEntity getOwnerFromRequest(OwnerRequest ownerRequest) {
		PetOwnerEntity ownerEntity = null;
        if (ownerRequest != null) {
        	ownerEntity = new PetOwnerEntity();
        	
        	ownerEntity.setInsertDate(new Date());
        	ownerEntity.setOwnerName(ownerRequest.getOwnerName());
        	ownerEntity.setOwnerSurname(ownerRequest.getOwnerSurname());
        	ownerEntity.setRut(ownerRequest.getRut());
        	ownerEntity.setEmail(ownerRequest.getEmail());
        	ownerEntity.setAddress(ownerRequest.getAddress());
        	ownerEntity.setPhoneNumber1(ownerRequest.getPhoneNumber1());
        	ownerEntity.setPhoneNumber2(ownerRequest.getPhoneNumber2());

        }
        
        return ownerEntity;
    }

}
