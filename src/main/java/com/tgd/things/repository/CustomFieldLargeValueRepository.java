package com.tgd.things.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tgd.things.beans.db.CustomFieldValue;

public interface CustomFieldLargeValueRepository extends CrudRepository<CustomFieldValue, String> {

	public Optional<CustomFieldValue> findById(Long id);

	@Query(value = "SELECT * FROM custom_field_large_value cflv "
			+ " where cflv.THING_THI_ID=?1 and cflv.CUSTOMFIELD_CFI_ID=?2", nativeQuery = true)
	public List<CustomFieldValue> findByThingAndField(Long thingId, Long fieldId);

}
