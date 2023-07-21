package com.cico.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer> {

	public List<LeaveType> findByIsActiveAndIsDelete(Boolean isActive,Boolean isDeleted);

}
