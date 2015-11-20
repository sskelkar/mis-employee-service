package com.maxxton.mis.employee.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maxxton.mis.employee.domain.Employee;
import com.maxxton.mis.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/mis")
@Api(value = "mis-employee-api", description = "MIS Employee Service API")
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  @RequestMapping(method = RequestMethod.GET, value = "/employee")
  @ApiOperation(value = "getAllEmployees", notes = "Retuns information of all employees.", response = Employee.class, responseContainer = "List")
  public Iterable<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/employee/{id}")
  @ApiOperation(value = "getEmployee", notes = "Retuns information of an employee for a given id.", response = Employee.class)
  public Employee getEmployee(@PathVariable("id") String id) {
    return employeeService.getEmployeeById(Long.valueOf(id));
  }

  @RequestMapping(method = RequestMethod.POST, value = "/employee")
  @ApiOperation(value = "addEmployee", notes = "Add a new employee. Returns the employee id, if successful.", response = Long.class)
  public Long addEmployee(String firstName, String middleName, String lastName, String userName, 
                          String password, String email, String birthDate, String sex, 
                          Double probationPeriodMonths, String panNumber, 
                          String passportNumber, String passportValidTill, String emergencyContactPerson, 
                          String emergencyContactPhoneNumber, String bloodGroup) {
    return employeeService.addEmployee(firstName, middleName, lastName, userName, 
                          password, email, new Date(), sex, 
                          probationPeriodMonths, panNumber, 
                          passportNumber, new Date(), emergencyContactPerson, 
                          emergencyContactPhoneNumber, bloodGroup);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/employee/{id}")
  @ApiOperation(value = "updateEmployee", notes = "Update an existing employee. Returns the employee id, if successful.", response = Long.class)
  public Long updateEmployee(@PathVariable("id") String id, String firstName, String middleName, String lastName, String userName, 
                          String password, String email, String birthDate, String sex, 
                          Double probationPeriodMonths, String panNumber, 
                          String passportNumber, String passportValidTill, String emergencyContactPerson, 
                          String emergencyContactPhoneNumber, String bloodGroup) {
    return employeeService.updateEmployee(id, firstName, middleName, lastName, userName, 
                          password, email, new Date(), sex, 
                          probationPeriodMonths, panNumber, 
                          passportNumber, new Date(), emergencyContactPerson, 
                          emergencyContactPhoneNumber, bloodGroup);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
  @ApiOperation(value = "removeEmployee", notes = "Remove an existing employee. Returns the employee id, if successful.", response = Long.class)
  public Long removeEmployee(@PathVariable("id") String id) 
  {
    return employeeService.removeEmployee(id);
  }
}