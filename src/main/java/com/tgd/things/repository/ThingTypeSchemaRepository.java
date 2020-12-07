package com.tgd.things.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tgd.things.beans.db.ThingType;

public interface ThingTypeSchemaRepository extends CrudRepository<ThingType, String> {

	public Optional<ThingType> findById(Long id);

	/*
	 * SELECT tt.* FROM THING_TYPE tt
LEFT JOIN  THING_TYPE_SCHEMA_THINGTYPE  ON THINGTYPESCHEMA_TTS_ID=THINGTYPE_TTY_ID 
LEFT JOIN  THING_TYPE_SCHEMA tts ON tts.TTS_ID=THINGTYPESCHEMA_TTS_ID
	 */
	 @Query("SELECT tts FROM ThingTypeSchema tts WHERE BOX_ID = ?1")
	 public List<ThingType> findAllByBoxId(Long boxId);

}