package com.ideas2it.employeemanagement.repo;

import com.ideas2it.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Collection<Employee> getEmployeesByStatus(String status);

    Optional<Employee> findByEmployeeIdAndStatus(int employeeId, String active);

    Employee findEmployeeByFirstName(String firstName);
}
