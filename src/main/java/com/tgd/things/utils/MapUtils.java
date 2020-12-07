package com.tgd.things.utils;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(MapUtils.class);

	private static String GOOGLE_MAP_PATTERN = "[-]?[\\d]+[.][\\d]*";

	public static HashMap<String, String> getLatLongFromGMap(String googleMapsUrl) {
		LOGGER.trace("### getLatLongFromGMap");

		HashMap<String, String> ret = new HashMap<String, String>();

		// "([A-Z])*@(([\\-0-9\\.])*)[,](([\\-0-9\\.])*)

		String splitUrl[] = googleMapsUrl.split("!3d");
		String latLong[] = splitUrl[splitUrl.length - 1].split("!4d");
		String longitude;

		if (latLong[1].indexOf("?") != -1) {
			longitude = latLong[1].split("\\?")[0];
		} else {
			longitude = latLong[1];
		}
		String latitude = latLong[0];

		/*
		 * Pattern p = Pattern.compile(GOOGLE_MAP_PATTERN); Matcher m =
		 * p.matcher(googleMapsUrl);
		 * 
		 * LOGGER.debug("--- count: " + m.groupCount());
		 * 
		 * while (m.find()) { LOGGER.debug("---> " + m.group(1) + "" +
		 * m.group(2)); }
		 * 
		 * // if our pattern matches the string, we can try to extract our
		 * groups if (m.find()) {
		 * 
		 * // get the two groups we were looking for String group2 = m.group(2);
		 * String group3 = m.group(3);
		 * 
		 * // print the groups, with a wee bit of formatting
		 * LOGGER.debug("{} :: {}", group2, group3); ret.put("lat",
		 * group2.replace(".", ",")); ret.put("lon", group3.replace(".", ","));
		 * LOGGER.trace("Coordinates: {} : {}", ret.get("lat"), ret.get("lon"));
		 * return ret; }
		 */

		ret.put("lat", latitude.replace(".", ","));
		ret.put("lon", longitude.replace(".", ","));
		LOGGER.trace("Coordinates: {} : {}", ret.get("lat"), ret.get("lon"));
		return ret;
	}
}
