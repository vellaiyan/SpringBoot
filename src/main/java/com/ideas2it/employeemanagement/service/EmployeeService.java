package com.ideas2it.employeemanagement.service;

import com.ideas2it.employeemanagement.dto.EmployeeDto;
import com.ideas2it.employeemanagement.model.Employee;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto addEmployee(EmployeeDto employeeDto);

    public List<EmployeeDto> getEmployees();

    public EmployeeDto getEmployeeById(int employeeId);

    public String deleteEmployeeById(int employeeId);

    public boolean checkEmployeeById(int employeeId);


}
