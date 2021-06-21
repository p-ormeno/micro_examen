package com.escalab.practice.vet.records.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.escalab.practice.vet.records.jpa.model.PetEntity;

/**
 * The Interface PetJpaRepository.
 */
@Repository
public interface PetJpaRepository extends JpaRepository<PetEntity, Long>{

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	@Query("SELECT P FROM PetEntity P "
			+ "WHERE UPPER(P.name) = UPPER(:name) ")
	List<PetEntity> findByName(@Param("name") String name);
	
	/**
	 * Find by name.
	 *
	 * @param ownerId the owner id
	 * @return the list
	 */
	@Query("SELECT P FROM PetEntity P "
			+ "WHERE P.owner = :ownerId ")
	List<PetEntity> findByOwner(@Param("ownerId") Long ownerId);
}
