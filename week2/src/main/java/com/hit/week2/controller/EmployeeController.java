package com.hit.week2.controller;

import com.hit.week2.model.Employee;
import com.hit.week2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/select")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

    @PostMapping(value = "/add")
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees/select";
    }

    @PostMapping(value = "/update")
    public String updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/employees/select";
    }

    @GetMapping(value = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees/select";
    }

    @PostMapping(value = "/deleteAll")
    public String deleteAllEmployees(@RequestBody List<String> idEmployees) {
        employeeService.deleteAllEmployee(idEmployees);
        return "redirect:/employees/select";
    }



}
