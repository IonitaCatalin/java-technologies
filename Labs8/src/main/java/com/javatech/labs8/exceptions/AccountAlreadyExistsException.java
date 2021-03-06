package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableConflictException;

import javax.ws.rs.core.Response;


public class AccountAlreadyExistsException extends TranslatableConflictException {

    public AccountAlreadyExistsException() {
        this.message = "Account exists with credentials";
    }
}
