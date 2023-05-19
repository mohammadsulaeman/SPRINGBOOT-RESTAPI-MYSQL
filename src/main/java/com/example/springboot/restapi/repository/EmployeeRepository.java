package com.example.springboot.restapi.repository;

import com.example.springboot.restapi.entity.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository  extends CrudRepository<Employee,Long> {
}
