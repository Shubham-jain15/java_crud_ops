package com.shubham.cruddemo;

import com.shubham.cruddemo.dao.StudentDAO;
import com.shubham.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student student = new Student("Shiv","Shakti","shiva@gmail.com");
		studentDAO.save(student);
		System.out.println("Student created");
		System.out.println("Database Updated");
	}
}
