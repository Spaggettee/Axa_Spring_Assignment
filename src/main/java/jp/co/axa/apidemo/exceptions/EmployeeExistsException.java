package jp.co.axa.apidemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Employee already exists")
public class EmployeeExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}