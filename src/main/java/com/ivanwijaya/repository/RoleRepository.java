package com.ivanwijaya.repository;

import com.ivanwijaya.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
}
