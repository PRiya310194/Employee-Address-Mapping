package com.example.EmployeeAddress.Mapping.controller;

import com.example.EmployeeAddress.Mapping.model.Employee;
import com.example.EmployeeAddress.Mapping.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping(value="/save")
    public ResponseEntity<String>addEmployee(@RequestBody Employee empData){
        int employeeId=employeeService.saveEmp(empData);
    return new ResponseEntity<>("Employee Saved with Id"+employeeId, HttpStatus.CREATED);
    }
    @GetMapping(value="/findAll")
    public ResponseEntity<List<Employee>>FindAllEmp(){
        List<Employee>empList=employeeService.findAllEmployee();
        return new ResponseEntity<>(empList,HttpStatus.FOUND);

    }
    @GetMapping(value="/ById/{employeeId}")
    public ResponseEntity<String>findEmpById(@PathVariable Integer employeeId){
        if(employeeId!=null){
String employee=employeeService.findEmpById(employeeId);
return new ResponseEntity<>(employee,HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>("please enter valid id ",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value="/delete/{employeeId}")
    public void deleteEmpById(@PathVariable Integer employeeId){
employeeService.deleteEmployee(employeeId);
    }
    @PutMapping(value="/update/{employeeId}")
    public ResponseEntity<String>updateEmployee(@PathVariable Integer employeeId,@RequestBody Employee employee){
        Employee ans=employeeService.updateEmployee(employeeId,employee);
        if(employeeId!=null){
return new ResponseEntity<>("Employee updated successfully"+employee,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("please enter valid employeeId",HttpStatus.BAD_REQUEST);
        }
    }
}
