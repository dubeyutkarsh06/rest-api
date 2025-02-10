package com.utkarsh.springboot.restapi.rest;

public class StudentException extends RuntimeException{
    public StudentException(String msg){
        super(msg);
    }
}
