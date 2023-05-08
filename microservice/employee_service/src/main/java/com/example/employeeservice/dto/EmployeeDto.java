package com.example.employeeservice.dto;

import com.example.employeeservice.entity.Employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    
    private Long id;

    @NonNull
    @NotBlank(message = "First name cannot be left blank.")
    @NotEmpty(message = "First name cannot be left empty.")
    private String firstName;

    @NonNull
    @NotBlank(message = "Last name cannot be left blank.")
    @NotEmpty(message = "Last name cannot be left empty.")
    private String lastName;

    @NonNull
    @NotBlank(message = "Email cannot be left blank.")
    @NotEmpty(message = "Email cannot be left empty.")
    @Email(message = "Please choose a valid email address.")
    private String email;

    private String departmentCode;

    // Employee to EmployeeDto mapper
    public EmployeeDto(Employee source) {
        this.id = source.getId();
        this.firstName = source.getFirstName();
        this.lastName = source.getLastName();
        this.email = source.getEmail();
        this.departmentCode = source.getDepartmentCode();
    }

    // constructor for feeding the database test employees
    public EmployeeDto(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public EmployeeDto(String firstName, String lastName, String email, String departmentCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departmentCode = departmentCode;
    }

}
