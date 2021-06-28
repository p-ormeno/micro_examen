package com.escalab.practice.composer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.escalab.practice.composer.composer.VetComposer;
import com.escalab.practice.composer.model.PetRecordDTO;

@RestController
public class ComposerController {
	
	/** The composer. */
	@Autowired
	private VetComposer composer;
	
	
	/**
	 * Gets the all pets by owners.
	 *
	 * @param rut the rut
	 * @return the all pets by owners
	 */
	@GetMapping("/vista/pets-by-owner/{rut}")
	public List<PetRecordDTO> getAllPetsByOwners(@PathVariable String rut){
		return composer.getAllPetsByOwners(rut);
	}

}
