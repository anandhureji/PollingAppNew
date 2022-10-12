package com.anandhu.PollingAppBackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anandhu.PollingAppBackend.models.Role;
import com.anandhu.PollingAppBackend.models.RoleName;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(RoleName roleName);

}
