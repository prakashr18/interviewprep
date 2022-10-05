package com.interview;

public class TransactionException extends Throwable{
    private String errorCode;
    private String errorMessage;

    public TransactionException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
