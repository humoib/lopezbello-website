package com.tgd.things.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgd.things.beans.db.security.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
