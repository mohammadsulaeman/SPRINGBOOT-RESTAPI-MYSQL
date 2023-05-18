package com.example.springboot.restapi.service;

import com.example.springboot.restapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee fetchEmployeeById(Long id);

    List<Employee> fetchAllEmployee();

    void   deletedEmployee(Long id);
}
