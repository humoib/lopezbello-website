package com.tgd.things.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tgd.things.beans.db.ThingAttachment;

public interface ThingAttachmentRepository extends CrudRepository<ThingAttachment, String> {

	@Query("SELECT ta FROM ThingAttachment ta WHERE THING_THI_ID = ?1")
	public List<ThingAttachment> getAttachemnts(Long thingId);

}

