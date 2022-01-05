package com.yordankarabelyov.Airlines.Management.System.exceptions;

public class PlaneCapacityExceededException extends RuntimeException {
    public PlaneCapacityExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}
