package com.escalab.practice.composer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.practice.composer.clients.OwnerFeignClient;
import com.escalab.practice.composer.model.PetOwnerDTO;

/**
 * The Class OwnerServiceImpl.
 */
@Service
public class OwnerServiceImpl implements OwnerService {
	
	@Autowired
	private OwnerFeignClient ownerFeignClient;
	
	/**
	 * Find owner.
	 *
	 * @param ownerRut the owner rut
	 * @return the pet owner DTO
	 */
	public PetOwnerDTO findOwner(String ownerRut) {
		return ownerFeignClient.findOwner(ownerRut);
	}

	
}
