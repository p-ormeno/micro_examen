package com.escalab.practice.vet.owners.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.escalab.practice.vet.owners.jpa.model.PetOwnerEntity;

/**
 * The Interface PetOwnerJpaRepository.
 */
@Repository
public interface PetOwnerJpaRepository extends JpaRepository<PetOwnerEntity, Long>{

	/**
	 * Find owner by rut.
	 *
	 * @param rut the rut
	 * @return the pet owner entity
	 */
	@Query("SELECT O FROM PetOwnerEntity O "
			+ "WHERE UPPER(O.rut) = UPPER(:rut) ")
	PetOwnerEntity findOwnerByRut(@Param("rut") String rut);
}
