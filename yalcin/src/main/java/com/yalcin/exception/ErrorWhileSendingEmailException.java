package com.yalcin.exception;

public class ErrorWhileSendingEmailException  extends  RuntimeException{
    public ErrorWhileSendingEmailException(String message) {
        super(message);
    }
}
