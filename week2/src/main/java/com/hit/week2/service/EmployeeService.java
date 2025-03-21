package com.hit.week2.service;

import com.hit.week2.model.Employee;
import com.hit.week2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    public void deleteAllEmployee(List<String> idEmployees) {
        employeeRepository.deleteAllById(idEmployees);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
