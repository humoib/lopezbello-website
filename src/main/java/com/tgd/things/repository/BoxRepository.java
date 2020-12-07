package com.tgd.things.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tgd.things.beans.db.Box;

public interface BoxRepository extends CrudRepository<Box, String> {

	public Optional<Box> findById(Long id);

	@Query("SELECT lastKey FROM Box b WHERE BOX_ID = ?1")
	public Integer getLastKey(Integer boxId);

	@Modifying
	@Query(value = "UPDATE BOX SET BOX_LAST_KEY = ?1 WHERE BOX_ID = ?2", nativeQuery = true)
	public void updateLastKey(Integer lastKey, Integer boxId);

}