package com.yalcin.exception;


public class AccessTokenExpiredException extends RuntimeException {
    public AccessTokenExpiredException(String explanation) {
        super(explanation);
    }
}
