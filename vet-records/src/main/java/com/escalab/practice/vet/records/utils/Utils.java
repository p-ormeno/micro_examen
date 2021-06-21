package com.escalab.practice.vet.records.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.escalab.practice.vet.records.domain.PetRecordDTO;
import com.escalab.practice.vet.records.domain.WeightDTO;
import com.escalab.practice.vet.records.domain.request.PetRequest;
import com.escalab.practice.vet.records.domain.request.WeightRequest;
import com.escalab.practice.vet.records.jpa.model.PetEntity;
import com.escalab.practice.vet.records.jpa.model.WeightEntity;

/**
 * The Class Utils.
 */
public class Utils {
	
	
	// DTOS
	/**
	 * Gets the weight DTO.
	 *
	 * @param weightEntity the weight entity
	 * @return the weight DTO
	 */
	public static WeightDTO getWeightDTO(WeightEntity weightEntity) {
		WeightDTO dto = null;
        if (weightEntity != null) {
            dto = new WeightDTO();

            dto.setWeightId(weightEntity.getWeightId());
            dto.setInsertDate(weightEntity.getInsertDate());
            dto.setWeight(weightEntity.getWeight());
            dto.setUnit(weightEntity.getUnit());
           
        }
        return dto;
    }
	
	/**
	 * Gets the weight log DTO.
	 *
	 * @param weightLog the weight log
	 * @return the weight log DTO
	 */
	public static List<WeightDTO> getWeightLogDTO(Iterable<WeightEntity> weightLog) {
		List<WeightDTO> dtos = null;

		if (weightLog != null && weightLog.iterator().hasNext()) {
			dtos = new ArrayList<>();

			for (Iterator<WeightEntity> weight = weightLog.iterator(); weight.hasNext();) {
				dtos.add(getWeightDTO(weight.next()));
			}
		}
		return dtos;
	}
	
	/**
	 * Gets the pet DTO.
	 *
	 * @param petEntity the pet entity
	 * @return the pet DTO
	 */
	public static PetRecordDTO getPetDTO(PetEntity petEntity) {
		PetRecordDTO dto = null;
        if (petEntity != null) {
            dto = new PetRecordDTO();

            dto.setPetId(petEntity.getPetId());
            dto.setInsertDate(petEntity.getInsertDate());
            dto.setName(petEntity.getName());
            dto.setRace(petEntity.getRace());
            dto.setSpecies(petEntity.getSpecies());
            dto.setBirthDay(petEntity.getBirthDay());
            dto.setDeathDay(petEntity.getDeathDay());
            dto.setColor(petEntity.getColor());
            dto.setBloodType(petEntity.getBloodType());
            dto.setIsDonor(petEntity.getIsDonor());
            dto.setIsNeutered(petEntity.getIsNeutered());
            dto.setChipId(petEntity.getChipId());
            dto.setChipNumbertEXT(petEntity.getChipNumbertEXT());
            dto.setSexType(petEntity.getSexType());
            dto.setWeight(getWeightLogDTO(petEntity.getWeight()));
            
        }
        return dto;
    }
	
	/**
	 * Gets the pets DTO.
	 *
	 * @param petList the pet list
	 * @return the pets DTO
	 */
	public static List<PetRecordDTO> getPetsDTO(Iterable<PetEntity> petList) {
		List<PetRecordDTO> dtos = null;

		if (petList != null && petList.iterator().hasNext()) {
			dtos = new ArrayList<>();

			for (Iterator<PetEntity> pet = petList.iterator(); pet.hasNext();) {
				dtos.add(getPetDTO(pet.next()));
			}
		}
		return dtos;
	}
	

	
	// ENTITIES
	
	/**
	 * Gets the weight DTO.
	 *
	 * @param weightDTO the weight DTO
	 * @return the weight DTO
	 */
	public static WeightEntity getWeightDTO(WeightDTO weightDTO) {
		WeightEntity weightEntity = null;
        if (weightDTO != null) {
        	weightEntity = new WeightEntity();

        	weightEntity.setWeightId(weightDTO.getWeightId());
        	weightEntity.setInsertDate(weightDTO.getInsertDate());
        	weightEntity.setWeight(weightDTO.getWeight());
        	weightEntity.setUnit(weightDTO.getUnit());           
        }
        
        return weightEntity;
    }
	
	/**
	 * Gets the pet entity.
	 *
	 * @param petDto the pet dto
	 * @return the pet entity
	 */
	public static PetEntity getPetEntity(PetRecordDTO petDto) {
		PetEntity petEntity = null;
        if (petDto != null) {
        	petEntity = new PetEntity();

        	petEntity.setPetId(petDto.getPetId());
        	petEntity.setInsertDate(petDto.getInsertDate());
        	petEntity.setName(petDto.getName());
        	petEntity.setRace(petDto.getRace());
        	petEntity.setSpecies(petDto.getSpecies());
        	petEntity.setBirthDay(petDto.getBirthDay());
        	petEntity.setDeathDay(petDto.getDeathDay());
        	petEntity.setColor(petDto.getColor());
        	petEntity.setBloodType(petDto.getBloodType());
        	petEntity.setIsDonor(petDto.getIsDonor());
        	petEntity.setIsNeutered(petDto.getIsNeutered());
        	petEntity.setChipId(petDto.getChipId());
        	petEntity.setChipNumbertEXT(petDto.getChipNumbertEXT());
        	petEntity.setSexType(petDto.getSexType());
            
        }
        return petEntity;
    }
	
	// OTHERS
	
	/**
	 * Gets the pet from request.
	 *
	 * @param petRequest the pet request
	 * @return the pet from request
	 */
	public static PetEntity getPetFromRequest(PetRequest petRequest) {
		PetEntity petEntity = null;
        if (petRequest != null) {
        	petEntity = new PetEntity();
        	
        	//If PetID exists we are updating the pet.
        	//If not, is a new pet so we add the insertDate
        	if(petRequest.getPetId() != null) {
        		petEntity.setPetId(petRequest.getPetId());
        	}else {
        		petEntity.setInsertDate(new Date());
        	}
        	
        	petEntity.setName(petRequest.getName());
        	petEntity.setRace(petRequest.getRace());
        	petEntity.setSpecies(petRequest.getSpecies());
        	petEntity.setBirthDay(petRequest.getBirthDay());
        	petEntity.setDeathDay(petRequest.getDeathDay());
        	petEntity.setColor(petRequest.getColor());
        	petEntity.setBloodType(petRequest.getBloodType());
        	petEntity.setIsDonor(petRequest.getIsDonor());
        	petEntity.setIsNeutered(petRequest.getIsNeutered());
        	petEntity.setChipId(petRequest.getChipId());
        	petEntity.setChipNumbertEXT(petRequest.getChipNumbertEXT());
        	petEntity.setSexType(petRequest.getSexType());
        	petEntity.setOwner(petRequest.getOwnerID());;

            
        }
        return petEntity;
    }
	
	
	/**
	 * Gets the weigh request.
	 *
	 * @param petRequest the pet request
	 * @return the weigh request
	 */
	public static WeightRequest getWeighRequest(PetRequest petRequest) {
		WeightRequest request = new WeightRequest();
		request.setUnit(petRequest.getWeightUnit());
		request.setWeight(petRequest.getWeight());
		request.setPetId(petRequest.getPetId());

		return request;

	}

}
