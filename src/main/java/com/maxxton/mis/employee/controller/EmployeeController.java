package com.maxxton.mis.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maxxton.mis.employee.domain.Employee;
import com.maxxton.mis.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/mis")
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;
  
  @RequestMapping(method = RequestMethod.GET, value = "/employee")
  public Iterable<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/employee/{id}")
  public Employee getEmployee(@PathVariable("id") String id) {
    return employeeService.getEmployeeById(Long.valueOf(id));
  }
  
  @RequestMapping(method = RequestMethod.GET, value = "/cc-emails-for-employee/{id}")
  public List<String> getCcEmailsForEmployee(@PathVariable("id") String id) {
    return employeeService.getCcEmailsForEmployee(Long.valueOf(id));
  }

  @RequestMapping(method = RequestMethod.POST, value = "/employee")
  public Long addEmployee(@RequestBody Employee employee) {
    return employeeService.addEmployee(employee);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/employee/{id}")
  public Long updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {
    return employeeService.updateEmployee(id, employee);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
  public Long removeEmployee(@PathVariable("id") String id) 
  {
    return employeeService.removeEmployee(id);
  }
}