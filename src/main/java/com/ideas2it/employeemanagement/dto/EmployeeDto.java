package com.ideas2it.employeemanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


public class EmployeeDto {
    private int employeeId;
    private int batch;
    private String firstName;
    private String gender;
    private String mobileNumber;
    private LocalDate createDate;

    private LocalDate modifiedDate;

    private String status;

    public EmployeeDto() {

    }

    public EmployeeDto(int employeeId, int batch, String firstName, String gender, String mobileNumber, LocalDate createDate, LocalDate modifiedDate, String status) {
        this.employeeId = employeeId;
        this.batch = batch;
        this.firstName = firstName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
