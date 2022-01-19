package com.tgd.things.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tgd.things.beans.CustomFieldReduced;
import com.tgd.things.beans.CustomFieldValueReduced;
import com.tgd.things.beans.db.CustomField;

public interface CustomFieldRepository extends CrudRepository<CustomField, String> {

	public Optional<CustomField> findById(Long id);

	/*
	 * SELECT tty_id, tty_name, cfi_key, cfi_name, cfi_type FROM CUSTOM_FIELD cfi
	 * left JOIN THING_TYPE_CUSTOMFIELD ttc ON cfi_id=ttc.customfield_cfi_id left
	 * JOIN THING_TYPE tty ON tty_id=ttc.thingtype_tty_id where tty.TTY_ID=1
	 */
	@Query(value = "SELECT cfi_id as id, cfi_key as _key, cfi_name as _name, cfi_type as _type FROM custom_field cfi "
			+ " LEFT JOIN THING_TYPE_CUSTOMFIELD ttc ON cfi_id = ttc.customfield_cfi_id "
			+ " LEFT JOIN THING_TYPE tty ON tty_id=ttc.thingtype_tty_id WHERE tty.TTY_ID=?1", nativeQuery = true)
	public List<CustomFieldReduced> getAllFieldsFromThingType(Long thingTypeId);

	@Query(value = "SELECT DISTINCT cfi_id as id, cfi_key as _key, cfi_name as _name, cfi_type as _type, cfv_value as _value FROM thing THI "
			+ " right JOIN THING_TYPE tty ON tty_id=thi.thingtype_tty_id  "
			+ " right JOIN THING_TYPE_CUSTOMFIELD ttc ON ttc.THINGTYPE_TTY_ID = tty_id  "
			+ " right JOIN CUSTOM_FIELD cfi ON cfi.cfi_id = ttc.CUSTOMFIELD_CFI_ID "
			+ " LEFT join CUSTOM_FIELD_VALUE cfv on cfv.CUSTOMFIELD_CFI_ID=cfi.cfi_id and THING_THI_ID = ?1"
			+ " where thi.THI_ID = ?1", nativeQuery = true)
	public List<CustomFieldValueReduced> getAllFieldValuesFromThing(Long thingId);

	@Query(value = "SELECT cfi_id as id, cfi_key as _key, cfi_name as _name, cfi_type as _type FROM custom_field cfi "
			+ " where cfi.CFI_NAME=?1", nativeQuery = true)
	public List<CustomFieldReduced> findByName(String fieldName);

	/*
	 * @Query(value =
	 * "SELECT cfi_key as key,TTY.tty_name as name FROM  CUSTOM_FIELD cfi " +
	 * "right JOIN THING_TYPE_CUSTOMFIELD ttc ON cfi_id = ttc.customfield_cfi_id " +
	 * "right JOIN THING_TYPE tty ON tty_id=ttc.thingtype_tty_id", nativeQuery =
	 * true) public List<CustomFieldReduced> getMyRows();
	 */
}