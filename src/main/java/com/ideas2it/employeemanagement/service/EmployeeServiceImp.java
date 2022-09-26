package com.ideas2it.employeemanagement.service;

import com.ideas2it.employeemanagement.constants.EmployeeConstants;
import com.ideas2it.employeemanagement.dto.EmployeeDto;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.repo.EmployeeRepository;
import io.swagger.annotations.Example;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        return modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);

    }

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = (List<Employee>) employeeRepository.getEmployeesByStatus("active");
        return employees.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).
                collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(int employeeId) {
        Optional<Employee> employee = employeeRepository.findByEmployeeIdAndStatus(employeeId, "active");
        return modelMapper.map(employee.get(), EmployeeDto.class);
    }

    @Override
    public String deleteEmployeeById(int employeeId) {
        Employee employee = modelMapper.map(getEmployeeById(employeeId), Employee.class);
        employee.setStatus(EmployeeConstants.INACTIVE);
        employeeRepository.save(employee);
        return "deleted successful";
    }

    @Override
    public boolean checkEmployeeById(int employeeId) {
        return employeeRepository.existsById(employeeId);
    }

    public EmployeeDto updateEmployee(int employeeId, EmployeeDto employeeDto) {
        if (checkEmployeeById(employeeId)) {
            employeeDto.setEmployeeId(employeeId);
            addEmployee(employeeDto);
            return employeeDto;
        }
        return null;
    }
}
