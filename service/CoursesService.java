package sgsits.cse.dis.academics.service;

import java.util.List;

public interface CoursesService {
	String getCourseIdByName(String name);
	
	String getNameByCourseId(String courseId);
	
	List<String> getCourseList();
}
