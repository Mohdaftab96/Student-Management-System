package com.StudentManagementSystem;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.repository.StudentRepository;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
		System.out.println("Student Management System Application Started");
	}


	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

//		Student student1 = new Student("Mohd", "Aftab", "mohdaftab98765@gmail.com");
//		studentRepository.save(student1);
//
//		Student student2 = new Student("Nazim","Pasha", "nazim98765@gmail.com");
//		studentRepository.save(student2);
//
//		Student student3 = new Student("Shad Ali", "Hasan", "shadalihasan98765@gmail.com");
//		studentRepository.save(student3);
	}
}

