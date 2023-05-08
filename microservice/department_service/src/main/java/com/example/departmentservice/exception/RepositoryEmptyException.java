package com.example.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RepositoryEmptyException extends RuntimeException {
    
    public RepositoryEmptyException() {
        super("The repository is currently empty.  You should not be getting this error.");
    }
}
