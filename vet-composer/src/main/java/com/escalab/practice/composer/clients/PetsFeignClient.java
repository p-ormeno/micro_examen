package com.escalab.practice.composer.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.escalab.practice.composer.model.PetRecordDTO;
import com.escalab.practice.composer.utils.Urls;

@FeignClient(name = "vet.records")
public interface PetsFeignClient {

	@GetMapping(path = Urls.PET_RECORD + Urls.PET_BY_OWNER)
	public @ResponseBody List<PetRecordDTO> findPets(@PathVariable Long ownerRut);

}
