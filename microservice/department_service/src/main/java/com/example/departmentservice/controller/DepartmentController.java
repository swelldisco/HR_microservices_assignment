package com.example.departmentservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.service.DepartmentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    // create a new department
    // http://127.0.0.1:8080/api/departments
    @PostMapping()
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody @Valid DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }

    // get a department by its name as a path variable
    // http://127.0.0.1:8080/api/departments/name?departmentName=Engineering
    @GetMapping("/name")
    public ResponseEntity<DepartmentDto> getDepartmentByName(@RequestParam String departmentName) {
        return new ResponseEntity<>(departmentService.getDepartmentByName(departmentName), HttpStatus.OK);
    }

    // get a department by its department code as a path variable
    // http://127.0.0.1:8080/api/departments/code?departmentCode=SALES
    @GetMapping("/code")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@RequestParam String departmentCode) {
        return new ResponseEntity<>(departmentService.getDepartmentByCode(departmentCode), HttpStatus.OK);
    }

    // get a list of all departments
    // http://127.0.0.1:8080/api/departments/all
    @GetMapping()
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    // update a department by its code as a path variable
    // http://127.0.0.1:8080/api/departments/ABC001
    @PutMapping("/{code}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("code") String departmentCode, @RequestBody @Valid DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.updateDepartment(departmentCode, departmentDto), HttpStatus.ACCEPTED);
    }

    // delete a department by its code as a path variable
    // http://127.0.0.1:8080/api/departments/ABC001
    @DeleteMapping("/{code}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("code") String departmentCode) {
        departmentService.deleteDepartment(departmentCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
