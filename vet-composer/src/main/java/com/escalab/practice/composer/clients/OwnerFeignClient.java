package com.escalab.practice.composer.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.escalab.practice.composer.model.PetOwnerDTO;
import com.escalab.practice.composer.utils.Urls;

@FeignClient(name = "vet.owners")
public interface OwnerFeignClient {

	@GetMapping(path = Urls.PET_OWNER + Urls.FIND_OWNER)
	public @ResponseBody PetOwnerDTO findOwner(@PathVariable String ownerRut);

}
