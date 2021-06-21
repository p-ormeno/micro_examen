package com.escalab.practice.vet.records.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.escalab.practice.vet.records.jpa.model.WeightEntity;

/**
 * The Interface WeightJpaRepository.
 */
@Repository
public interface WeightJpaRepository extends JpaRepository<WeightEntity, Long>{

	/**
	 * Gets the weight log by pet id.
	 *
	 * @param petId the pet id
	 * @return the weight log by pet id
	 */
	@Query("SELECT W FROM WeightEntity W "
			+ "WHERE W.pet = :petId ")
	List<WeightEntity> getWeightLogByPetId(@Param("petId") Long petId);
}
