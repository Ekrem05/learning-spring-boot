package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;

import java.util.List;

public interface CourseDAO {

    void save(Course course);
    List<Course> findWithSpecifiedInstructor(int instructorId);
    List<Course> getAllCoursesWithStudents();
}
