package com.example.employeeservice.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.exception.EmployeeNotFoundException;
import com.example.employeeservice.exception.RepositoryEmptyException;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee newEmployee = new Employee(employeeDto);
        employeeRepository.save(newEmployee);
        return new EmployeeDto(newEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return new EmployeeDto(pokeEmployeeById(id));
    }

    @Override
    public List<EmployeeDto> getEmployeeByName(String firstName, String lastName) {
        if (!employeeRepository.findAllByFirstNameAndLastNameIgnoreCase(firstName, lastName).isEmpty() && employeeRepository.findAllByFirstNameAndLastNameIgnoreCase(firstName, lastName) != null) {
            return employeeRepository.findAllByFirstNameAndLastNameIgnoreCase(firstName, lastName).stream()
                .map(e -> new EmployeeDto(e))
                .toList();
        } else {
            throw new EmployeeNotFoundException("Employee", "Name", firstName + " " + lastName);
        }
    }

    @Override
    public EmployeeDto getEmployeeByEmail(String email) {
        return new EmployeeDto(pokeEmployeeByEmail(email));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        if (!employeeRepository.findAll().isEmpty() && employeeRepository.findAll() != null) {
            return employeeRepository.findAll().stream()
                .map(e -> new EmployeeDto(e))
                .toList();
        } else {
            throw new RepositoryEmptyException();
        }
    }

    @Override
    public List<EmployeeDto> getAllByDepartment(String departmentCode) {
        if (!employeeRepository.findAllByDepartmentCodeIgnoreCase(departmentCode).isEmpty() && employeeRepository.findAllByDepartmentCodeIgnoreCase(departmentCode) != null) {
            return employeeRepository.findAllByDepartmentCodeIgnoreCase(departmentCode).stream()
                .map(e -> new EmployeeDto(e))
                .toList();
        } else {
            throw new EmployeeNotFoundException("Employee", "Department Code", departmentCode);
        }
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = pokeEmployeeById(id);
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartmentCode(employeeDto.getDepartmentCode());
        employeeRepository.save(employee);
        return new EmployeeDto(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new EmployeeNotFoundException("Employee", "Employee Id", id.toString());
        }
    }

    // violently shake Optionals to make sure there's an Employee inside before returning them to the calling method
    private Employee pokeEmployeeById(Long id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee", "Employee Id", id.toString()));
    }

    private Employee pokeEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee", "Employee Email", email));
    }
    
}
