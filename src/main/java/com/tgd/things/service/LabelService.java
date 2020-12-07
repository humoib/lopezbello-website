package com.tgd.things.service;

import java.util.HashMap;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tgd.things.beans.db.Label;

@Service
@Transactional
public class LabelService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LabelService.class);

	/**
	 * 
	 * @return
	 */
	public HashMap<Integer, Label> getLabels() {
		LOGGER.debug("## getLabels");

		HashMap<Integer, Label> labels = new HashMap<Integer, Label>();
		labels.put(1, new Label(1, "label1", "green"));
		labels.put(2, new Label(2, "label2", "red"));
		labels.put(3, new Label(3, "label3", "blue"));

		return labels;
	}

}
