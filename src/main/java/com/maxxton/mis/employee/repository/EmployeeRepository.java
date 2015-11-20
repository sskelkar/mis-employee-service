package com.maxxton.mis.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.maxxton.mis.employee.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}