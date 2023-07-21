package com.cico.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyStackRepository extends JpaRepository<TechnologyStack, Integer> {

	TechnologyStack findByTechnologyName(String technologyName);

	@Query("SELECT ts FROM TechnologyStack ts WHERE ts.id = :TechnologyStackId AND ts.isDeleted = false")
	Optional<TechnologyStack> findById(@Param("TechnologyStackId") Integer technologyStackId);

	@Query("SELECT ts FROM TechnologyStack ts WHERE  ts.isDeleted = false")
	List<TechnologyStack> findAll();

}