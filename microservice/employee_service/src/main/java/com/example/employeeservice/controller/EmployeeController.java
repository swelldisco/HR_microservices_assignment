package com.example.employeeservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    // create a new employee
    // http://127.0.0.1:8081/api/employees
    @PostMapping()
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    // get an employee by id
    // http://127.0.0.1:8081/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    // get an employee by name.  Returns a list as you may have multiple employees with the same name
    // http://127.0.0.1:8081/api/employees/name?firstName=Billy&lastName=Bob
    @GetMapping("/name")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByName(@RequestParam String firstName, @RequestParam String lastName) {
        return new ResponseEntity<>(employeeService.getEmployeeByName(firstName, lastName), HttpStatus.OK);
    }

    // get an employee by email
    // http://127.0.0.1:8081/api/employees/email?email=BillyBob@gmail.com
    @GetMapping("/email")
    public ResponseEntity<EmployeeDto> getEmployeeByEmail(@RequestParam String email) {
        return new ResponseEntity<>(employeeService.getEmployeeByEmail(email), HttpStatus.OK);
    }

    // get all employees in the repository
    // http://127.0.0.1:8081/api/employees
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    // get all employees in a department
    // http://127.0.0.1:8081/api/employees/department/TEST
    @GetMapping("/department/{code}")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesByDepartment(@PathVariable("code") String departmentCode) {
        return new ResponseEntity<>(employeeService.getAllByDepartment(departmentCode), HttpStatus.OK);
    }

    // update an employee by id
    // http://127.0.0.1:8081/api/employees/1
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeeDto), HttpStatus.ACCEPTED);
    }

    // delete an employee by id
    // http://127.0.0.1:8081/api/employees/1
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
