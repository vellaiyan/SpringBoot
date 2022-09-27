package com.ideas2it.employeemanagement.service.iml;

import com.ideas2it.employeemanagement.constants.EmployeeConstants;
import com.ideas2it.employeemanagement.dto.EmployeeDto;
import com.ideas2it.employeemanagement.exception.UserNotFoundException;
import com.ideas2it.employeemanagement.mapper.EmployeeMapper;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.repo.EmployeeRepository;
import com.ideas2it.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        employeeDto.setStatus(EmployeeConstants.ACTIVE);
        Employee employee = employeeMapper.fromDto(employeeDto);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = (List<Employee>) employeeRepository.getEmployeesByStatus(EmployeeConstants.ACTIVE);
        return employees.stream().map(employeeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(int employeeId) throws UserNotFoundException {
        Optional<Employee> employee = employeeRepository.findByEmployeeIdAndStatus(employeeId, EmployeeConstants.ACTIVE);
        try {
            return employeeMapper.toDto(employee.get());
        } catch (NoSuchElementException noSuchElementException) {
            throw new UserNotFoundException("Employee Not Found");
        }
    }

    @Override
    public String deleteEmployeeById(int employeeId) throws UserNotFoundException {
        Optional<Employee> employee = employeeRepository.findByEmployeeIdAndStatus(employeeId, EmployeeConstants.ACTIVE);
        try {
            employee.get().setStatus(EmployeeConstants.INACTIVE);
            return employeeId + "Deleted successfully";
        } catch (NoSuchElementException noSuchElementException) {
            throw new UserNotFoundException("Employee Not Found");
        }

    }

    @Override
    public boolean checkEmployeeById(int employeeId) {
        return employeeRepository.existsById(employeeId);
    }

    @Override
    public String updateEmployee(EmployeeDto employeeDto) {
        if (checkEmployeeById(employeeDto.getEmployeeId())) {
            addEmployee(employeeDto);
            return "Employee Updated Successfully";
        } else {
            return "Employee Id Not found";
        }
    }

}
