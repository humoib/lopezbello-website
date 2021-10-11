package com.tgd.things.utils;

public class FrontWrapper {

	public String getBoxType(int boxType) {

		switch (boxType) {
		// 1 - Stuff
		case 1:
			return "Stuff";
		// 2 - Process
		case 2:
			return "Process";
		// 3 - Software
		case 3:
			return "Stuff";
		// 4 - Service Management
		case 4:
			return "Service Management";
		// 5 - Photo
		case 5:
			return "Photo";
		// 6 - Places
		case 6:
			return "Places";
		}
		return "--";
	}

}
