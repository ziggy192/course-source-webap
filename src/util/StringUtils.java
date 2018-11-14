package util;

import constant.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
	public static List<Integer> toIntegerList(String integerListString, String delimiter) throws NumberFormatException {

		ArrayList<Integer> result = new ArrayList<>();

		if ( integerListString  == null  || integerListString.trim().isEmpty()) {
			return result;
		}
		String[] params = integerListString.split(",");
		for (String s : params) {
			result.add(Integer.parseInt(s.trim()));
		}
		return result;
	}

	public static List<Integer> toIntegerList(String integerListString) {
		return toIntegerList(integerListString, AppConstants.DEFAULT_URL_PARAM_LIST_DELIMITER);
	}

	public static String toDurationString(int duration) {
		if (duration < 0) {
			return "";
		}
		int hour = duration / 3600;
		int minute = (duration % 3600) / 60;
		int second = duration %60;
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}

}
