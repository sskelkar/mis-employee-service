package com.maxxton.mis.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxxton.mis.employee.domain.Employee;
import com.maxxton.mis.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  private final String INDIA_TIMEZONE = "Asia/Kolkata";

  /**
   * Simple method to return all the employees.
   * 
   * @return
   */
  public Iterable<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  public Employee getEmployeeById(Long employeeId) {
    return employeeRepository.findOne(employeeId);
  }

  /**
   * To add leaves of a particular type for an employee by his/her manager.
   * 
   * @param employeeId
   * @param year
   * @param leaveCount
   * @param leaveTypeId
   * @return employeeLeaveId of the added leave.
   */
  public Long addEmployee(Employee employee) 
  {
  	return employeeRepository.save(employee).getEmployeeId();
  }

  /**
   * To add leaves of a particular type for an employee by his/her manager.
   * 
   * @param employeeId
   * @param year
   * @param leaveCount
   * @param leaveTypeId
   * @return employeeLeaveId of the added leave.
   */
  public Long updateEmployee(String employeeId, Employee employee) {
    if(employeeId == null)
      throw new RuntimeException("Employee id is required.");
    
    if(getEmployeeById(Long.valueOf(employeeId)) == null)
      throw new RuntimeException("Employee not found with the given id.");
    
    return employeeRepository.save(employee).getEmployeeId();
  }

  public Long removeEmployee(String employeeId)
  {
    if(employeeId == null)
      throw new RuntimeException("Employee id is required.");
    Employee employee = getEmployeeById(Long.valueOf(employeeId));
    if(employee == null)
      throw new RuntimeException("Employee not found with the given id.");
    employeeRepository.delete(employee);
    return Long.valueOf(employeeId);
  }

}