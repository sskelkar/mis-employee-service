package com.maxxton.mis.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.maxxton.mis.employee.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>
{

//  @Query("select e from Employee e " + "connect by prior e.manager_id = e.employee_id " + "where e.employeeId = ?1 ")
//  List<Employee> findCcEmailsForEmployee(Long employeeId);

}