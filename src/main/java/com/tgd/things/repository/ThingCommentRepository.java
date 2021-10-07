package com.tgd.things.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tgd.things.beans.db.ThingComment;

public interface ThingCommentRepository extends CrudRepository<ThingComment, String> {

	public Optional<ThingComment> findById(Long id);

	@Query(value = "SELECT * FROM COMMENT  WHERE THING_THI_ID = ?1", nativeQuery = true)
			
	//SELECT tc.* FROM COMMENT tc LEFT JOIN THING_THINGCOMMENT ttc on ttc.THINGCOMMENT_COM_ID = tc.COM_ID "
//			+ " WHERE ttc.THING_THI_ID = ?1", nativeQuery = true)
	List<ThingComment> getCommentsFromThing(Long id);

	// public Iterable<ThingComment> findAll();

	// @Query("SELECT lastKey FROM Box b WHERE BOX_ID = ?1")
	// public Integer getLastKey(Integer boxId);

	// @Modifying
	// @Query(value = "UPDATE BOX SET BOX_LAST_KEY = ?1 WHERE BOX_ID = ?2",
	// nativeQuery = true)
	// public void updateLastKey(Integer lastKey, Integer boxId);

}
