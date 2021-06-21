package com.escalab.practice.vet.records.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.escalab.practice.vet.records.domain.PetRecordDTO;
import com.escalab.practice.vet.records.domain.WeightDTO;
import com.escalab.practice.vet.records.domain.request.PetRequest;
import com.escalab.practice.vet.records.domain.request.WeightRequest;
import com.escalab.practice.vet.records.jpa.model.PetEntity;
import com.escalab.practice.vet.records.jpa.model.WeightEntity;
import com.escalab.practice.vet.records.jpa.repository.PetJpaRepository;
import com.escalab.practice.vet.records.jpa.repository.WeightJpaRepository;
import com.escalab.practice.vet.records.service.PetRecordService;
import com.escalab.practice.vet.records.utils.Utils;

/**
 * The Class PetRecordServiceImpl.
 */
@Service
public class PetRecordServiceImpl implements PetRecordService {

	/** The pet repository. */
	@Autowired
	private PetJpaRepository petRepository;
	
	/** The weight repository. */
	@Autowired
	private WeightJpaRepository weightRepository;
	
	
	/**
	 * Adds the new pet.
	 *
	 * @param petRequest the pet request
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Object> addNewPet(PetRequest petRequest) {
		ResponseEntity<Object> response = null;
		
		PetEntity newPet = Utils.getPetFromRequest(petRequest);

		newPet = petRepository.save(newPet);

		if (newPet.getPetId() != null) {
			// We create the first weight of the pet if exist
			if (petRequest.getWeight() != null) {
				WeightEntity firstWeight = saveWeight(Utils.getWeighRequest(petRequest), newPet);
				if (firstWeight.getWeightId() != null) {
					response = new ResponseEntity<>("OK", HttpStatus.CREATED);
				}
			} else {
				response = new ResponseEntity<>("OK", HttpStatus.CREATED);
			}
		} else {
			response = new ResponseEntity<>("NOK", HttpStatus.NO_CONTENT);
		}
		

		return response;
	}
	
	/**
	 * Update pet.
	 *
	 * @param petRequest the pet request
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Object> updatePet(PetRequest petRequest) {
		ResponseEntity<Object> response = null;

		if (petRequest.getPetId() != null) {
			PetEntity savedPet = Utils.getPetFromRequest(petRequest);

			petRepository.save(savedPet);
			response = new ResponseEntity<>("OK", HttpStatus.OK);
		} else {
			response = new ResponseEntity<>("NOK", HttpStatus.NO_CONTENT);
		}

		return response;
	}

	/**
	 * Adds the weight.
	 *
	 * @param weightRequest the weight request
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Object> addWeight(WeightRequest weightRequest) {
		ResponseEntity<Object> response = null;
		
		Optional<PetEntity> petEntity = petRepository.findById(weightRequest.getPetId());
		if(petEntity.isPresent()) {
			this.saveWeight(weightRequest, petEntity.get());
			response = new ResponseEntity<>("OK", HttpStatus.OK);
		}else {
			response = new ResponseEntity<>("NOK", HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	/**
	 * Save weight.
	 *
	 * @param petRequest the pet request
	 * @param newPet the new pet
	 * @return the weight entity
	 */
	private WeightEntity saveWeight(WeightRequest weightRequest, PetEntity newPet) {
		WeightEntity weight = new WeightEntity();
		weight.setPet(newPet);
		weight.setInsertDate(new Date());
		weight.setWeight(weightRequest.getWeight());
		weight.setUnit(weightRequest.getUnit());

		return weightRepository.save(weight);
	}
	
	/**
	 * Gets the weight log.
	 *
	 * @param petId the pet id
	 * @return the weight log
	 */
	public List<WeightDTO> getWeightLog(Long petId) {
		List<WeightEntity> weightLog = weightRepository.getWeightLogByPetId(petId);
		List<WeightDTO> result = null;

		if (weightLog != null && weightLog.isEmpty()) {
			result = Utils.getWeightLogDTO(weightLog);

			Collections.sort(result, new Comparator<WeightDTO>() {
				public int compare(WeightDTO w1, WeightDTO w2) {
					return w1.getInsertDate().compareTo(w2.getInsertDate());
				}
			});
		}

		return result;
	}

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	@Override
	public List<PetRecordDTO> findByName(String name) {
		List<PetEntity> pets = petRepository.findByName(name);
		return Utils.getPetsDTO(pets);
	}

	/**
	 * Find by owner.
	 *
	 * @param ownerRut the owner rut
	 * @return the list
	 */
	@Override
	public List<PetRecordDTO> findByOwner(Long ownerRut) {
		List<PetEntity> pets = petRepository.findByOwner(ownerRut);
		return Utils.getPetsDTO(pets);
	}

}
