package com.yalcin.exception;

import com.yalcin.enums.ErrorCodes;

public class BadRequestException extends RuntimeException {

    private int messageCode;

    public BadRequestException(String message, ErrorCodes messageCode) {
        super(message);
        this.messageCode = messageCode.getValue();
    }

    public int getmessageCode(){
        return this.messageCode;
    }
}