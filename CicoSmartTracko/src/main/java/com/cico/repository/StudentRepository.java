package com.cico.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Optional<Student> findByUserIdAndIsActive(String username, boolean b);

	Student findByDeviceId(String deviceId);

	Student findByUserId(String userId);

	Student findByStudentId(Integer studentId);
	
}
