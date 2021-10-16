package com.tgd.things.utils;

public class FrontWrapper {

	public String getBoxType(int boxType) {

		// 1 - Stuff
		// 2 - Process
		// 3 - Project Management
		// 4 - Software
		// 5 - Service Management
		// 6 - Photo
		// 80 - Places

		switch (boxType) {

		// 1 - Stuff
		case 1:
			return "Stuff";

		// 2 - Process
		case 2:
			return "Process";

		// 3 - Project Management
		case 3:
			return "Project Management";

		// 4 - Software
		case 4:
			return "Agile Software Development";

		// 5 - Service Management
		case 5:
			return "Service Management";

		// 6 - Photo
		case 6:
			return "Photo";

		// 80 - Places
		case 80:
			return "Places";

		}
		return "--";
	}

}
