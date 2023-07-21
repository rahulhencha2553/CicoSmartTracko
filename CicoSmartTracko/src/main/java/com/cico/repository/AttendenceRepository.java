package com.cico.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendance, Integer> {

	public Attendance findByStudentIdAndCheckInDate(Integer studentId,LocalDate date);
	
	@Query("SELECT a FROM Attendance a WHERE a.studentId=:studentId AND a.checkInDate<:currentDate AND a.checkOutDate is null ORDER BY checkInDate DESC")
	Attendance findByStudentIdAndCheckInDateLessThanCurrentDate(Integer studentId, LocalDate currentDate);

	public Attendance findByStudentIdAndCheckInDateAndCheckOutDate(Integer studentId, LocalDate date, LocalDate checkOutDate );

	
	@Query("SELECT a FROM Attendance a WHERE a.studentId=:studentId AND a.checkInDate between :startDate AND :endDate")
	public Page<Attendance> findAttendanceHistory(Integer studentId, LocalDate startDate, LocalDate endDate, PageRequest of);
	
	@Query("SELECT a FROM Attendance a WHERE a.studentId=:studentId AND MONTH(a.checkInDate)=:monthNo")
	public List<Attendance> findByStudentIdAndMonthNo(@Param("studentId") Integer studentId,@Param("monthNo") Integer monthNo);
}
