package com.buzznote.campaign.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("NOT FOUND");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
