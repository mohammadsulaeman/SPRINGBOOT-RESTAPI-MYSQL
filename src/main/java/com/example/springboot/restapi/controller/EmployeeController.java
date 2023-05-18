package com.example.springboot.restapi.controller;

import com.example.springboot.restapi.entity.Employee;
import com.example.springboot.restapi.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> fetchAllEmployee(){
        List<Employee> employeeList = employeeService.fetchAllEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> fetchEmployeeById(@PathVariable("id") Long employeeId)
    {
        Employee employee = employeeService.fetchEmployeeById(employeeId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee){
        employee.setEmployeeId(id);
        Employee Employee = employeeService.updateEmployee(employee);
        System.out.println("Update Employee Controller = "+Employee);
        return new ResponseEntity<>(Employee,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee employeeAdd = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employeeAdd,HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletedEmployee(@PathVariable("id") Long id){
         employeeService.deletedEmployee(id);
         return new ResponseEntity<>("delete Employee Id = "+id + " successfully", HttpStatus.OK);
    }
}
