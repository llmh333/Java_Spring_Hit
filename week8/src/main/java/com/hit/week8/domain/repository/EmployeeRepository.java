package com.hit.week8.domain.repository;

import com.hit.week8.domain.dto.request.CreateEmployeeSearchRequest;
import com.hit.week8.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
    @Query(value = "select e from Employee e where (e.fullName like %:fullName% OR :fullName is null) and (e.position.id=:positionID OR :positionID is null ) and (e.department.id=:departmentID OR :departmentID is null )")
    List<Employee> searchEmployee(@Param("fullName") String fullName, @Param("positionID") Long positionID, @Param("departmentID") Long departmentID);
}
