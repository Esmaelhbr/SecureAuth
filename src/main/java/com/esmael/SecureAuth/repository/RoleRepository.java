package com.esmael.SecureAuth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmael.SecureAuth.entity.Role;
import com.esmael.SecureAuth.entity.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName name);

}
