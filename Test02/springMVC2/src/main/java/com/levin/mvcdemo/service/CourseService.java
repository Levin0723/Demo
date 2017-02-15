package com.levin.mvcdemo.service;

import com.levin.mvcdemo.model.Course;
import org.springframework.stereotype.Service;


@Service
public interface CourseService {
	
	
	Course getCoursebyId(Integer courseId);
	

	
	

}
