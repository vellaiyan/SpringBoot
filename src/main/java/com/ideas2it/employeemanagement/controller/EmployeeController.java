package com.ideas2it.employeemanagement.controller;

import com.ideas2it.employeemanagement.dto.EmployeeDto;
import com.ideas2it.employeemanagement.exception.UserNotFoundException;
import com.ideas2it.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> add(@RequestBody @Valid EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.addEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> get(@PathVariable("id") int employeeId) throws UserNotFoundException {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));

    }

    @GetMapping("getAll")
    public ResponseEntity<List<EmployeeDto>> getAll() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody EmployeeDto employeeDto) throws UserNotFoundException {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int employeeId) throws UserNotFoundException {
        return ResponseEntity.ok(employeeService.deleteEmployeeById(employeeId));
    }


}
