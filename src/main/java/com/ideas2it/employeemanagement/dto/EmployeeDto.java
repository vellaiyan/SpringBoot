package com.ideas2it.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private int employeeId;

    private int batch;

    @NotNull(message = "First Name shouldnt be null")
    private String firstName;

    @NotNull
    @Pattern(regexp = "^male|female|others$", message = "Please choose correct option")
    private String gender;

    @NotNull
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid mobile number")
    private String mobileNumber;

    @NotNull
    private String password;

    private LocalDate createDate;

    private LocalDate modifiedDate;

    private String status;

}
