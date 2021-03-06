package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableNotFoundException;

public class DocumentNotFoundException extends TranslatableNotFoundException {
    public DocumentNotFoundException() {
        this.message = "Requested document does not exist";
    }
}
