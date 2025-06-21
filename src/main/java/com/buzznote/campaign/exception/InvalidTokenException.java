package com.buzznote.campaign.exception;

public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException() {
        super("UNAUTHORIZED");
    }

    public InvalidTokenException(String s) {
        super(s);
    }

}
