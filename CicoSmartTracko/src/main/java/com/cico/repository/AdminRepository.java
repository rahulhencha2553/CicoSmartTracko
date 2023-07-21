package com.cico.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Optional<Admin> findByAdminEmail(String adminEmail);

	Optional<Admin> findByAdminId(String username);
}
