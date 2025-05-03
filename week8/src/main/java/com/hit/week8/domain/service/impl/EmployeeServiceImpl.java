package com.hit.week8.domain.service.impl;

import com.hit.week8.Mapper.DepartmentMapper;
import com.hit.week8.Mapper.EmployeeMapper;
import com.hit.week8.Mapper.PositionMapper;
import com.hit.week8.Mapper.UserMapper;
import com.hit.week8.constant.ErrorCode;
import com.hit.week8.domain.dto.repsonse.EmployeeResponseDTO;
import com.hit.week8.domain.dto.repsonse.PositionResponseDTO;
import com.hit.week8.domain.dto.request.CreateEmployeeRequest;
import com.hit.week8.domain.dto.request.CreateEmployeeSearchRequest;
import com.hit.week8.domain.dto.request.UpdateEmployeeRequest;
import com.hit.week8.domain.entity.Department;
import com.hit.week8.domain.entity.Employee;
import com.hit.week8.domain.entity.Position;
import com.hit.week8.domain.entity.User;
import com.hit.week8.domain.exception.NotFoundException;
import com.hit.week8.domain.repository.DepartmentRepository;
import com.hit.week8.domain.repository.EmployeeRepository;
import com.hit.week8.domain.repository.PositionRepository;
import com.hit.week8.domain.repository.UserRepository;
import com.hit.week8.domain.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    private final EmployeeMapper employeeMapper;
    private final PositionMapper positionMapper;
    private final UserMapper userMapper;
    private final DepartmentMapper departmentMapper;

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseDTO> employeeResponseDTOList = new ArrayList<>();
        for (Employee employee : employees) {
            employeeResponseDTOList.add(employeeMapper.toEmployeeResponseDTO(employee));
        }
        return employeeResponseDTOList;
    }

    @Override
    public List<EmployeeResponseDTO> searchFlexibleEmployees(String fullName, Long positionID, Long departmentID) {
        System.out.println(positionID);
        List<Employee> employees = employeeRepository.searchEmployee(fullName, positionID, departmentID);
        List<EmployeeResponseDTO> employeeResponseDTOList = new ArrayList<>();
        for (Employee employee : employees) {
            employeeResponseDTOList.add(employeeMapper.toEmployeeResponseDTO(employee));
        }
        return employeeResponseDTOList;
    }


    @Override
    public EmployeeResponseDTO addEmployee(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = employeeMapper.toEmployee(createEmployeeRequest);
        if (createEmployeeRequest.getSalary() != null) {
            employee.setSalary(createEmployeeRequest.getSalary());
        }
        if (createEmployeeRequest.getDateOfBirth() != null) {
            employee.setDateOfBirth(createEmployeeRequest.getDateOfBirth());
        }
        if (createEmployeeRequest.getPositionID() != null) {
            Position newPosition = positionRepository.findById(createEmployeeRequest.getPositionID()).orElseThrow(() -> new NotFoundException(ErrorCode.POSITION_NOT_FOUND));
            employee.setPosition(newPosition);
        }
        if (createEmployeeRequest.getDepartmentID() != null) {
            Department newDepartment = departmentRepository.findById(createEmployeeRequest.getDepartmentID()).orElseThrow(() -> new NotFoundException(ErrorCode.DEPARTMENT_NOT_FOUND));
            employee.setDepartment(newDepartment);
        }
        if (createEmployeeRequest.getUserID() != null) {
            User newUser = userRepository.findById(createEmployeeRequest.getUserID()).orElseThrow(() -> new NotFoundException(ErrorCode.USER_NOT_FOUND));
            employee.setUser(newUser);
        }
        return employeeMapper.toEmployeeResponseDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long employeeID, UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = employeeRepository.findById(employeeID).orElseThrow(() -> new NotFoundException(ErrorCode.EMPLOYEE_NOT_FOUND));
        if (updateEmployeeRequest.getFullName() != null) {
            employee.setFullName(updateEmployeeRequest.getFullName());
        }
        if (updateEmployeeRequest.getSalary() != null) {
            employee.setSalary(updateEmployeeRequest.getSalary());
        }
        if (updateEmployeeRequest.getDateOfBirth() != null) {
            employee.setDateOfBirth(updateEmployeeRequest.getDateOfBirth());
        }
        if (updateEmployeeRequest.getPositionID() != null) {
            Position newPosition = positionRepository.findById(updateEmployeeRequest.getPositionID()).orElseThrow(() -> new NotFoundException(ErrorCode.POSITION_NOT_FOUND));
            employee.setPosition(newPosition);
        }
        if (updateEmployeeRequest.getDepartmentID() != null) {
            Department newDepartment = departmentRepository.findById(updateEmployeeRequest.getDepartmentID()).orElseThrow(() -> new NotFoundException(ErrorCode.DEPARTMENT_NOT_FOUND));
            employee.setDepartment(newDepartment);
        }
        if (updateEmployeeRequest.getUserId() != null) {
            User newUser = userRepository.findById(updateEmployeeRequest.getUserId()).orElseThrow(() -> new NotFoundException(ErrorCode.USER_NOT_FOUND));
            employee.setUser(newUser);
        }
        return employeeMapper.toEmployeeResponseDTO(employeeRepository.save(employee));

    }

    @Override
    public void deleteEmployee(Long employeeID) {
        Employee employee = employeeRepository.findById(employeeID).orElseThrow(() -> new NotFoundException(ErrorCode.EMPLOYEE_NOT_FOUND));
        employeeRepository.delete(employee);
    }
}
