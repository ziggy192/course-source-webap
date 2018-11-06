package other;

import javax.ws.rs.WebApplicationException;
import java.util.ArrayList;

public class QueryIntegerList extends ArrayList<Integer> {
	public QueryIntegerList(String param) {
		super();
		String[] params = param.split(",");
		for (String s : params) {

			try {
				this.add(Integer.parseInt(s.trim()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
				throw new WebApplicationException(404);
			}
		}
	}
}
