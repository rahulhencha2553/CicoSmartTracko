package com.cico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {

	@Query("SELECT b FROM Batch b WHERE b.batchStartDate > :currentDate")
	List<Batch> findAllByBatchStartDate();

}

