package com.ideas2it.employeemanagement.exception;

public class CustomException extends Exception {

    public CustomException() {
        super();
    }

    public CustomException(String exception) {
        super(exception);
    }

    public CustomException(Throwable throwable) {
        super(throwable);
    }

    public CustomException(String exception, Throwable throwable) {
        super(exception, throwable);
    }


}
