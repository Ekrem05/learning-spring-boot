package com.kuv2xode.cruddemo;

import com.kuv2xode.cruddemo.dao.StudentDAO;
import com.kuv2xode.cruddemo.entity.Student;
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
	public CommandLineRunner runner(StudentDAO studentDAO) {
		return args -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//printStudents(studentDAO);
			//findByLastName(studentDAO);
			//updateStudent(studentDAO);
			//removeStudent(studentDAO);

		};
	}

	private void removeStudent(StudentDAO studentDAO) {
		studentDAO.delete(1);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.getById(1);
		student.setFirstName("John The Second");
		Student updated = studentDAO.update(student);
		System.out.println(updated);
	}

	private void findByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.getByLastName("Doe");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void printStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.getAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("John","Doe","john@gmail.com");
		studentDAO.save(student);

	}


	public static void readStudent(StudentDAO studentDAO){
		System.out.println("Student with id 1 is: "+ studentDAO.getById(1));
	}

}
