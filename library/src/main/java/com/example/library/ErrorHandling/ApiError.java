package com.example.library.ErrorHandling;

import org.springframework.http.HttpStatus;

public class ApiError {
     private HttpStatus status;
    private String message;
    private Throwable throwable;

    public ApiError(HttpStatus status, String message, Throwable throwable) {
        this.status = status;
        this.message = message;
        this.throwable = throwable;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    
    
}
