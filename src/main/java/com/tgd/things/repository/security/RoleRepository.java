package com.tgd.things.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgd.things.beans.db.security.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
