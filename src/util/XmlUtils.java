package util;


import entity.CourseList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class XmlUtils {
	public static StringWriter toXmlStream(CourseList courseEntities) {
		StringWriter os = new StringWriter();
		try {
			JAXBContext context = JAXBContext.newInstance(courseEntities.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(courseEntities, os);
		} catch (JAXBException e) {
			e.printStackTrace();

		}

		return os;

	}
}
