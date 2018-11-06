package util;

import constant.AppConstants;

import javax.ws.rs.WebApplicationException;
import java.util.ArrayList;
import java.util.List;

public class StringUtils {
	public static List<Integer> toIntegerList(String integerListString, String delimiter) throws NumberFormatException {

		ArrayList<Integer> result = new ArrayList<>();
		if (integerListString.trim().isEmpty()) {
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
}
