package com.tgd.things.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tgd.things.beans.db.ThingType;

public interface ThingTypeRepository extends CrudRepository<ThingType, String> {

	public Optional<ThingType> findById(Long id);

	@Query(value = "SELECT tt.* FROM THING_TYPE tt "
			+ "LEFT JOIN THING_TYPE_SCHEMA_THINGTYPE TTST ON TTST.THINGTYPE_TTY_ID = tt.TTY_ID "
			+ "LEFT JOIN THING_TYPE_SCHEMA TTS on tts.TTS_ID = TTST.THINGTYPESCHEMA_TTS_ID "
			+ "LEFT JOIN BOX b on b.BOX_THINGTYPE_SCHEMA = TTST.THINGTYPESCHEMA_TTS_ID "
			+ "WHERE b.BOX_ID = ?1", nativeQuery = true)
	public List<ThingType> findAllByBoxId(Long boxId);

}