package com.ideas2it.employeemanagement.controller;

import com.ideas2it.employeemanagement.constants.EmployeeConstants;
import com.ideas2it.employeemanagement.dto.EmployeeDto;
import com.ideas2it.employeemanagement.exception.CustomException;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.repo.EmployeeRepository;
import com.ideas2it.employeemanagement.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.awt.font.OpenType;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/welcome")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeServiceImp employeeService;

    @PostMapping("/insertEmployee")
    public EmployeeDto add(@RequestBody EmployeeDto employeeDto) {
        employeeDto.setStatus(EmployeeConstants.ACTIVE);
        return employeeService.addEmployee(employeeDto);
    }

    @GetMapping("/getEmployee{id}")
    public EmployeeDto get(@PathVariable("id") int employeeId) throws CustomException {
        try {
            if (employeeService.checkEmployeeById(employeeId)) {
                return employeeService.getEmployeeById(employeeId);
            }
        } catch (EntityNotFoundException | NoSuchElementException exception) {
            throw new CustomException("Exception occured while getting employee by id", exception);
        }
        return new EmployeeDto();
    }

    @GetMapping("/getEmployees")
    public List<EmployeeDto> getAll() {
        return employeeService.getEmployees();
    }

    @GetMapping("/updateEmployee{id}")
    public EmployeeDto update(@PathVariable("id") int employeeId, EmployeeDto employeeDto) throws CustomException {
        return employeeService.updateEmployee(employeeId, employeeDto);
    }

    @PostMapping("/deleteEmployee{id}")
    public String delete(@PathVariable("id") int employeeId) {
        if (employeeService.checkEmployeeById((employeeId))) {
            return employeeService.deleteEmployeeById(employeeId);
        } else {
            return "Employee is not available";
        }
    }
}
