package com.tgd.things.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tgd.things.beans.db.Box;

public interface BoxRepository extends CrudRepository<Box, String> {

	public Optional<Box> findById(Long id);

	@Query("SELECT b FROM Box b WHERE BOX_KEY = ?1")
	public Optional<Box> findByBoxKey(String boxKey);

	@Query("SELECT lastKey FROM Box b WHERE BOX_ID = ?1")
	public Long getLastKey(Long boxId);

	@Modifying
	@Query(value = "UPDATE BOX SET BOX_LAST_KEY = ?1 WHERE BOX_ID = ?2", nativeQuery = true)
	public void updateLastKey(Long lastKey, Long boxId);

}