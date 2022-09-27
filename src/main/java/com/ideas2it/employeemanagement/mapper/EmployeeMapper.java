package com.ideas2it.employeemanagement.mapper;

import com.ideas2it.employeemanagement.dto.EmployeeDto;
import com.ideas2it.employeemanagement.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee fromDto(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getEmployeeId(), employeeDto.getBatch(), employeeDto.getFirstName(),
                employeeDto.getGender(), employeeDto.getMobileNumber(), employeeDto.getPassword(), employeeDto.getCreateDate(),
                employeeDto.getModifiedDate(), employeeDto.getStatus());

    }

    public EmployeeDto toDto(Employee employee) {
        return new EmployeeDto(employee.getEmployeeId(), employee.getBatch(), employee.getFirstName(),
                employee.getGender(), employee.getMobileNumber(), employee.getPassword(), employee.getCreateDate(),
                employee.getModifiedDate(), employee.getStatus());
    }
}
