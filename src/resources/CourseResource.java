package resources;

import dao.CourseDAO;
import entity.CourseEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/course")
@Produces(MediaType.APPLICATION_XML)
public class CourseResource {

	@GET
	@Path("")
	public List<CourseEntity> getCourseByName(
			@DefaultValue("") @QueryParam("query") String query
			,@DefaultValue("") @QueryParam("subject") String subject
			,@DefaultValue("") @QueryParam("category") String category
			, @DefaultValue("") @QueryParam("filter") String filter
			, @DefaultValue("") @QueryParam("sort") String sort
			, @DefaultValue("1") @QueryParam("page") int page
	) {
		return CourseDAO.getInstance().searchCourse(query);
	}
}
