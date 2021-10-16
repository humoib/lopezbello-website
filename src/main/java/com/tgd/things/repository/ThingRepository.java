package com.tgd.things.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Cascade;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tgd.things.beans.ThingPojoSearcher;
import com.tgd.things.beans.db.Thing;

public interface ThingRepository extends PagingAndSortingRepository<Thing, Long> {

	// TODO Limit 20
	@Query("SELECT t FROM Thing t ORDER by created desc")
	List<Thing> getFirstTwentyThings();

	@Query("SELECT t FROM Thing t WHERE BOX_BOX_ID = ?1")
	List<Thing> getBoxThings(Long id);

	@Query(value = "(SELECT t.THI_ID as id, t.THI_SUMMARY as summary, t.THI_CREATED_DATETIME as created FROM THING t "
			+ "RIGHT JOIN THING_RELATION source on source.SOURCETHINGID = t.THI_ID "
			+ " WHERE source.TARGETTHINGID= ?1 ) UNION "
			+ "( SELECT t.THI_ID as id, t.THI_SUMMARY as summary, t.THI_CREATED_DATETIME as created FROM THING t "
			+ "RIGHT JOIN THING_RELATION target on target.TARGETTHINGID = t.THI_ID "
			+ " WHERE target.SOURCETHINGID= ?1 )", nativeQuery = true)
	public List<ThingPojoSearcher> findRelatedById(Long thingId);

	@Query(value = "SELECT t.THI_ID as id, t.THI_SUMMARY as summary, t.THI_CREATED_DATETIME as created FROM THING t "
			+ "WHERE THI_SUMMARY LIKE '%?1%'", nativeQuery = true)
	public List<ThingPojoSearcher> searchByText(Long thingId);

	List<Thing> findBySummaryContainingIgnoreCase(String text);

	@Query(value = "SELECT t.* FROM THING t " + " LEFT JOIN BOX b ON b.BOX_ID = t.BOX_BOX_ID "
			+ "WHERE BOX_KEY = ?1 AND THI_KEY = ?2 ", nativeQuery = true)
	Thing findByThingKey(String boxKey, Long key);

	@Modifying
//	@Cascade(value = { null })
	@Query(value = "DELETE FROM THING_RELATION WHERE SOURCETHINGID = ?1 OR TARGETTHINGID = ?1", nativeQuery = true)
	public int deleteRelationsById(Long thingId);

}
