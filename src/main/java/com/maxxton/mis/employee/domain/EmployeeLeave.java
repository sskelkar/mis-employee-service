package com.maxxton.mis.employee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class EmployeeLeave {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE_LEAVE")
  @SequenceGenerator(name = "SEQ_EMPLOYEE_LEAVE", sequenceName = "SEQ_EMPLOYEE_LEAVE", allocationSize = 1)
  private Long employeeLeaveId;
  private Long employeeId;
  private Long year;
  private Double leaveCount;
  private Long leaveTypeId;

  public Long getEmployeeLeaveId() {
    return employeeLeaveId;
  }

  public void setEmployeeLeaveId(Long employeeLeaveId) {
    this.employeeLeaveId = employeeLeaveId;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public Long getYear() {
    return year;
  }

  public void setYear(Long year) {
    this.year = year;
  }

  public Double getLeaveCount() {
    return leaveCount;
  }

  public void setLeaveCount(Double leaveCount) {
    this.leaveCount = leaveCount;
  }

  public Long getLeaveTypeId() {
    return leaveTypeId;
  }

  public void setLeaveTypeId(Long leaveTypeId) {
    this.leaveTypeId = leaveTypeId;
  }
}