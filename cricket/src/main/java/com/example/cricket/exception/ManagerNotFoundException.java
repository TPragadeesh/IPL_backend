package com.example.cricket.exception;


public class ManagerNotFoundException extends Exception {
    public ManagerNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
