package com.tgd.things.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tgd.things.beans.db.Thing;
import com.tgd.things.beans.db.ThingRelation;

public interface ThingRelationRepository extends CrudRepository<ThingRelation, String> {

	public Optional<ThingRelation> findById(Long id);

	@Query(value = "SELECT id from ThingRelation WHERE sourceThingId = ?1 and targetThingId = ?2")
	public List<Long> findBySourceAndTargetIds(Long sourceThingId, Long targetThingId);

	@Modifying
	@Query(value = "UPDATE THING_RELATION SET sourceThingId = ?2, targetThingId = ?3 WHERE ID = ?1", nativeQuery = true)
	public void updateRelation(Long id, Long sourceThingId, Long targetThingId);

	@Modifying
	@Query(value = "INSERT INTO THING_RELATION (sourceThingId, targetThingId) VALUES ( ?1, ?2 )", nativeQuery = true)
	public void insertRelation(Long sourceThingId, Long targetThingId);

}