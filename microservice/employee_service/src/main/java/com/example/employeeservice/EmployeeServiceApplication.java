package com.example.employeeservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class EmployeeServiceApplication implements CommandLineRunner {

	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// ** use this to add employees to the database **
		// List<EmployeeDto> testEmployees = Arrays.asList(
		// 	new EmployeeDto("Billy", "Bob", "BillyBob@gmail.com", "IT"),
		// 	new EmployeeDto("Jim", "Bob", "JB@UVA.edu", "SALES"),
		// 	new EmployeeDto("Jasper", "Jones", "JJ@mail.ru", "SALES"),
		// 	new EmployeeDto("Bubba", "Beauregard", "BubsJr@fakemail.com", "DATA_SCI"),
		// 	new EmployeeDto("Jethro", "McGimpy", "NoTullJethro@gmail.com", "ENG"),
		// 	new EmployeeDto("Otis", "Wright", "TheWrightOtis@gmail.com", "HR")
		// );

		// for (EmployeeDto employee : testEmployees) {
		// 	employeeService.createEmployee(employee);
		// }
	}

}
