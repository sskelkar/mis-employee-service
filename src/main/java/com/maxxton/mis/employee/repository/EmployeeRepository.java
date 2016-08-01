package com.maxxton.mis.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maxxton.mis.employee.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}