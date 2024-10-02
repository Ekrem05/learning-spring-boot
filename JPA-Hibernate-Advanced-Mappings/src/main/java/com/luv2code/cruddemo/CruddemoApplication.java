package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.CourseDAO;
import com.luv2code.cruddemo.dao.InstructorDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmdRunner(InstructorDAO instructorDAO,CourseDAO courseDAO) {

		return runner->{
			System.out.println("Hello World");
			//createInstructor(instructorDAO);
			//findById(instructorDAO,2);
			//deleteInstructor(instructorDAO,2);
			//findCoursesOfInstructor(instructorDAO,courseDAO);
			//createCourseAndStudents(courseDAO);
			getCourses(courseDAO);
		};
	}

	private void getCourses(CourseDAO courseDAO) {

		List<Course>courses= courseDAO.getAllCoursesWithStudents();

		for(Course course:courses){
			System.out.println(course);
			System.out.println(course.getStudents());
		}

	}

	private void createCourseAndStudents(CourseDAO courseDAO) {
		Course course = new Course("GO Programming language");

		Student john = new Student("Jonny","Depp","jonny@gmail.com");
		Student mikey = new Student("Mikey","Depp","mikey@gmail.com");

		course.addStudent(john);
		course.addStudent(mikey);

		courseDAO.save(course);
		System.out.println("Created course with 2 students");

	}

	private void findCoursesOfInstructor(InstructorDAO instructorDAO, CourseDAO courseDAO) {
		Instructor instructor = instructorDAO.findById(2);
		System.out.println(instructor);
		System.out.println(courseDAO.findWithSpecifiedInstructor(2));

	}

	private void deleteInstructor(InstructorDAO instructorDAO, int id) {
		instructorDAO.delete(id);
	}

	private void findById(InstructorDAO instructorDAO, int id) {
		Instructor instructor = instructorDAO.findById(id);

		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());

	}

	public void createInstructor(InstructorDAO dao){
		Instructor instructor = new Instructor("Mike","Mentzer","mikey@gmail.com");
		InstructorDetail detail = new InstructorDetail("mikeyFitness","weightlifting");
		instructor.setInstructorDetail(detail);
		instructor.add(new Course("PPL Program"));
		instructor.add(new Course("Full body program"));
		instructor.add(new Course("5X5 program"));
		dao.save(instructor);
		System.out.println("Created Instructor");

	}

}
