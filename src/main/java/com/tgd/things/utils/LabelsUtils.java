package com.tgd.things.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tgd.things.beans.db.Label;
import com.tgd.things.service.LabelService;

public class LabelsUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(LabelsUtils.class);

	@Autowired
	LabelService labelService;

	public LabelsUtils() {
		// this.labelService = new LabelService();
	}

	public String getHtmlForLabels(String labels) {
		if (labels != null && !labels.isEmpty()) {
			String[] labelsArray = labels.split(":");
			ArrayList<String> labelsList = new ArrayList(Arrays.asList(labelsArray));

			HashMap<Integer, Label> allLabels = labelService.getLabels();

			String toRet = "";
			for (String label : labelsList) {
				Label labelTmp = allLabels.get(Integer.parseInt(label));
				if (labelTmp != null) {
					// toRet += "<mark class='tag-sample'>" + labelTmp.getName()
					// +
					// "</mark>&nbsp;";
					toRet += "<span class='badge badge-primary'>" + labelTmp.getName() + "</span>&nbsp;";
				}
			}
			return toRet;
		} else {
			return "";
		}
	}
}
