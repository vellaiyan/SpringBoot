package com.ideas2it.employeemanagement.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String exception) {
        super(exception);
    }

    public UserNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public UserNotFoundException(String exception, Throwable throwable) {
        super(exception, throwable);
    }
}

