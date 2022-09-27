package com.ideas2it.employeemanagement.controller;

import com.ideas2it.employeemanagement.dto.AuthResuest;
import com.ideas2it.employeemanagement.dto.EmployeeDto;
import com.ideas2it.employeemanagement.exception.UserNotFoundException;
import com.ideas2it.employeemanagement.service.EmployeeService;
import com.ideas2it.employeemanagement.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

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

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAll() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @PutMapping("/{id}")
    public String update(@RequestBody EmployeeDto employeeDto) throws UserNotFoundException {
        return employeeService.updateEmployee(employeeDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int employeeId) throws UserNotFoundException {
        return employeeService.deleteEmployeeById(employeeId);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> generateToken(@RequestBody AuthResuest authResuest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authResuest.getFirstName(), authResuest.getPassword()));
        } catch (Exception exception) {
            throw new Exception("invalid username/password");
        }
        System.out.println(ResponseEntity.ok(jwtUtil.generateToken(authResuest.getFirstName())));
        return ResponseEntity.ok(jwtUtil.generateToken(authResuest.getFirstName()));
    }
}
