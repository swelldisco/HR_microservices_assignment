package com.example.departmentservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class DepartmentServiceApplication implements CommandLineRunner {

	private DepartmentService departmentService;

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// auto generate department DTOs for the database here
		// List<DepartmentDto> testDepartments = Arrays.asList(
		// 	new DepartmentDto("IT", "Information Technology", "IT"),
		// 	new DepartmentDto("Sales", "Sales and Marketing", "SALES"),
		// 	new DepartmentDto("HR", "Human Resources", "HR"),
		// 	new DepartmentDto("Engineering", "Product development", "ENG"),
		// 	new DepartmentDto("Data Science", "Market research, development, and product discovery", "DATA_SCI")
		// );

		// for (DepartmentDto department : testDepartments) {
		// 	departmentService.createDepartment(department);
		// }
	}

}
