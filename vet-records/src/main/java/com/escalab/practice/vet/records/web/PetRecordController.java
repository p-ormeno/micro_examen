package com.escalab.practice.vet.records.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.escalab.practice.vet.records.domain.PetRecordDTO;
import com.escalab.practice.vet.records.domain.WeightDTO;
import com.escalab.practice.vet.records.domain.request.PetRequest;
import com.escalab.practice.vet.records.domain.request.WeightRequest;
import com.escalab.practice.vet.records.service.PetRecordService;
import com.escalab.practice.vet.records.utils.Urls;

/**
 * The Class PetRecordController.
 */
@CrossOrigin
@RestController
@RequestMapping(value = Urls.PET_RECORD)
public class PetRecordController {
	
	/** The pet record service. */
	@Autowired
	private PetRecordService petRecordService;

	/**
	 * Add a new pet record.
	 *
	 * @param petRequest the pet request
	 * @return the response entity
	 */
	@PostMapping(path = Urls.NEW_PET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> newPetRecord(@RequestBody PetRequest petRequest) {
		return petRecordService.addNewPet(petRequest);
	}
	
	/**
	 * Update pet record.
	 *
	 * @param petRequest the pet request
	 * @return the response entity
	 */
	@PostMapping(path = Urls.UPDATE_PET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> updatePetRecord(@RequestBody PetRequest petRequest) {
		return petRecordService.updatePet(petRequest);
	}
	
	/**
	 * Adds the weight.
	 *
	 * @param weightRequest the weight request
	 * @return the response entity
	 */
	@PostMapping(path = Urls.ADD_WEIGHT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> addWeight(@RequestBody WeightRequest weightRequest) {
		return petRecordService.addWeight(weightRequest);
	}
	
	/**
	 * Gets the weight log.
	 *
	 * @param petID the pet ID
	 * @return the weight log
	 */
	@GetMapping(path = Urls.GET_WEIGHT)
	public @ResponseBody List<WeightDTO> getWeightLog(@PathVariable Long petID) {
		return petRecordService.getWeightLog(petID);
	}
	
	/**
	 * Find by pets by name.
	 *
	 * @param name the name
	 * @return the response entity
	 */
	@GetMapping(path = Urls.PET_BY_NAME)
	public @ResponseBody List<PetRecordDTO> findByName(@PathVariable String name) {
		return petRecordService.findByName(name);
	}
	
	/**
	 * Find by pets by owner.
	 *
	 * @param ownerRut the owner rut
	 * @return the list
	 */
	@GetMapping(path = Urls.PET_BY_OWNER)
	public @ResponseBody List<PetRecordDTO> findPets(@PathVariable Long ownerRut) {
		return petRecordService.findByOwner(ownerRut);
	}
	
}
