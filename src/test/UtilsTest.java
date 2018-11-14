package test;

import dao.CourseDAO;
import entity.CourseEntity;
import entity.CourseList;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import java.io.IOException;

public class UtilsTest {

	public static Logger logger = LoggerFactory.logger(UtilsTest.class);

	public static void main(String[] args) throws IOException {
//		testToXmlStream();
	}
//	public static void testToXmlStream() throws IOException {
//
//		List<CourseEntity> courseEntityList = CourseDAO.getInstance().searchCourse("huong");
//
//		CourseList courseList = new CourseList();
//
//		courseList.getCourse().addAll(courseEntityList);
//
//		StringWriter stringWriter = XmlUtils.toXmlStream(courseList);
//		String xmlString = stringWriter.toString();
//
//		System.out.println(xmlString);
//		logger.info(xmlString);
//
//		stringWriter.close();
//
//	}

}
