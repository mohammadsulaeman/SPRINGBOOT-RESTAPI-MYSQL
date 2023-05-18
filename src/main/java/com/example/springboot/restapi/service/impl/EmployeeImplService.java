package com.example.springboot.restapi.service.impl;

import com.example.springboot.restapi.entity.Employee;
import com.example.springboot.restapi.repository.EmployeeRepository;
import com.example.springboot.restapi.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeImplService implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        System.out.println("Employee Id = "+employee.getEmployeeId());
       Employee employeeAdd = employeeRepository.findById(employee.getEmployeeId()).get();

        // Setting Up Object
        employeeAdd.setEmployeeFirstName(employee.getEmployeeFirstName());
        employeeAdd.setEmployeeLastName(employee.getEmployeeLastName());
        employeeAdd.setEmployeeEmail(employee.getEmployeeEmail());
        employeeAdd.setEmployeePhone(employee.getEmployeePhone());
        employeeAdd.setEmployeeAddress(employee.getEmployeeAddress());
        System.out.println("Employee Add = "+employeeAdd.toString());
        // update
        Employee updateEmployee = employeeRepository.save(employeeAdd);
        System.out.println("Update Employee Fetch = "+updateEmployee);
        return updateEmployee;
    }

    @Override
    public Employee fetchEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.get();
    }

    @Override
    public List<Employee> fetchAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void deletedEmployee(Long id) {

      employeeRepository.deleteById(id);
    }
}
