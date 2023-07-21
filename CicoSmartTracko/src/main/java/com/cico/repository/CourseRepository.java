package com.cico.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Integer> {


	@Transactional
	@Modifying
	@Query("Update Course c Set isDeleted=1 Where c.courseId=:courseId")
	public int deleteCourse(@Param("courseId") Integer courseId);

	public Page<Course> findAllByIsDeleted(boolean b,PageRequest p);
}