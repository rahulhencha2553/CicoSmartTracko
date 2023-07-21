package com.cico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAlertRepository extends JpaRepository<JobAlert, Integer> {

	Page<JobAlert> findAllByTypeAndIsDeletedAndIsActive(String type, PageRequest p, Boolean isDeleted,
			Boolean isActive);

	@Query("SELECT u FROM JobAlert u WHERE (u.companyName LIKE CONCAT(:field, '%') OR u.jobTitle LIKE CONCAT(:field, '%') OR u.technicalSkills LIKE CONCAT(:field, '%')) AND u.isDeleted = false ")
	List<JobAlert> jobSearchAdmin(@Param("field") String field);

	@Query("SELECT u FROM JobAlert u WHERE (u.companyName LIKE CONCAT(:field, '%') OR u.jobTitle LIKE CONCAT(:field, '%') OR u.technicalSkills LIKE CONCAT(:field, '%')) AND u.isDeleted = false AND u.isActive = true")
	List<JobAlert> jobSearchStudent(@Param("field") String field);

	Page<JobAlert> findAllByIsDeleted(PageRequest p, Boolean isDeleted);

	Optional<JobAlert> findByJobIdAndIsDeletedAndIsActive(Integer id, Boolean isDeleted, Boolean isActive);
}