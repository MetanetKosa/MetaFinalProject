package com.example.metawater.exception;

import org.springframework.security.authentication.AccountStatusException;

public class NotAuthenticatedException extends AccountStatusException {
    public NotAuthenticatedException(String message) {
        super(message);
    }
}
