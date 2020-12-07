package com.tgd.things.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tgd.things.beans.ThingPojo;
import com.tgd.things.beans.ThingPojo2;
import com.tgd.things.beans.db.Thing;

//import es.excentia.jiracloud.datafieldsapp.controller.MainController;

public interface ThingRepository extends CrudRepository<Thing, Long> {

	// TODO Limit 20
	@Query("SELECT t FROM Thing t ")
	List<Thing> getFirstTwentyThings();

	@Query("SELECT t FROM Thing t WHERE  BOX_BOX_ID = ?1")
	List<Thing> getBoxThings(Long id);

	@Query(value = "(SELECT t.THI_ID as id, t.THI_SUMMARY as summary, t.THI_CREATED as created FROM THING t "
			+ "RIGHT JOIN THING_RELATION source on source.SOURCETHINGID = t.THI_ID "
			+ " WHERE source.TARGETTHINGID= ?1 ) UNION "
			+ "( SELECT t.THI_ID as id, t.THI_SUMMARY as summary, t.THI_CREATED as created FROM THING t "
			+ "RIGHT JOIN THING_RELATION target on target.TARGETTHINGID = t.THI_ID "
			+ " WHERE target.SOURCETHINGID= ?1 )", nativeQuery = true)
	public List<ThingPojo2> findRelatedById(Long thingId);

}
