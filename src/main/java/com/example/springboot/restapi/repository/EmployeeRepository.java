package com.example.springboot.restapi.repository;

import com.example.springboot.restapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
}
