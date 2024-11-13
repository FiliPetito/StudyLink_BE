package com.lykeon.StudyLink.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lykeon.StudyLink.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
}
