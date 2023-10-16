package com.desafios.accounts.exception.types;

public class InsufficientFundException extends RuntimeException{
    public InsufficientFundException(String message) {
        super(message);
    }
}
