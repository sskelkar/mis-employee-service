package com.maxxton.mis.employee.service;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxxton.mis.employee.domain.Employee;
import com.maxxton.mis.employee.domain.EmployeeLeave;
import com.maxxton.mis.employee.repository.EmployeeRepository;

import java.util.Date;

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
  public Long addEmployee(String firstName, String middleName, String lastName, String userName, 
                          String password, String email, Date birthDate, String sex, 
                          Double probationPeriodMonths, String panNumber, 
                          String passportNumber, Date passportValidTill, String emergencyContactPerson, 
                          String emergencyContactPhoneNumber, String bloodGroup) {
    Employee employee = new Employee();
    employee.setFirstName(firstName);
    employee.setMiddleName(middleName);
    employee.setLastName(lastName);
    employee.setUserName(userName);
    employee.setPassword(password);
    employee.setEmail(email);
    employee.setBirthDate(birthDate);
    employee.setSex(sex);
    employee.setProbationPeriodMonths(probationPeriodMonths);
    employee.setPanNumber(panNumber);
    employee.setPassportNumber(passportNumber);
    employee.setPassportValidTill(passportValidTill);
    employee.setEmergencyContactPerson(emergencyContactPerson);
    employee.setEmergencyContactPhoneNumber(emergencyContactPhoneNumber);
    employee.setBloodGroup(bloodGroup);

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
  public Long updateEmployee(String employeeId, String firstName, String middleName, String lastName, String userName, 
                          String password, String email, Date birthDate, String sex, 
                          Double probationPeriodMonths, String panNumber, 
                          String passportNumber, Date passportValidTill, String emergencyContactPerson, 
                          String emergencyContactPhoneNumber, String bloodGroup) {
    if(employeeId == null)
      throw new RuntimeException("Employee id is required.");
    Employee employee = getEmployeeById(Long.valueOf(employeeId));
    if(employee == null)
      throw new RuntimeException("Employee not found with the given id.");
    System.out.println("*** Employee found: " + employee.getEmployeeId());
    if(firstName != null)
      employee.setFirstName(firstName);
    if(middleName != null)
      employee.setMiddleName(middleName);
    if(lastName != null)
      employee.setLastName(lastName);
    if(userName != null)
      employee.setUserName(userName);
    if(password != null)
      employee.setPassword(password);
    if(email != null)
      employee.setEmail(email);
    if(birthDate != null)
      employee.setBirthDate(birthDate);
    if(sex != null)
      employee.setSex(sex);
    if(probationPeriodMonths != null)
      employee.setProbationPeriodMonths(probationPeriodMonths);
    if(panNumber != null)
      employee.setPanNumber(panNumber);
    if(passportNumber != null)
      employee.setPassportNumber(passportNumber);
    if(passportValidTill != null)
      employee.setPassportValidTill(passportValidTill);
    if(emergencyContactPerson != null)
      employee.setEmergencyContactPerson(emergencyContactPerson);
    if(emergencyContactPhoneNumber != null)
      employee.setEmergencyContactPhoneNumber(emergencyContactPhoneNumber);
    if(bloodGroup != null)
      employee.setBloodGroup(bloodGroup);

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