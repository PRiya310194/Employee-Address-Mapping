package com.example.EmployeeAddress.Mapping.service;

import com.example.EmployeeAddress.Mapping.dao.EmployeeRepository;
import com.example.EmployeeAddress.Mapping.model.Address;
import com.example.EmployeeAddress.Mapping.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public int saveEmp(Employee empData) {
Employee employee=employeeRepository.save(empData);
        return employee.getEmployeeId();
    }

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }


    public String findEmpById(Integer employeeId) {
        if(employeeRepository.findById(employeeId).isPresent()){
            Employee employee=employeeRepository.findById(employeeId).get();
            return employee.toString();
        }
        else{
            return "please enter valid employeeId";
        }
    }

    public void deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee updateEmployee(Integer employeeId, Employee employee) {
            Employee empData=employeeRepository.findById(employeeId).get();
              empData.setFirstName(employee.getFirstName());
              empData.setLastName(employee.getLastName());
              Address address=employee.getAddress();
               empData.setAddress(address);
               return empData;
    }
}
