package com.dq.exceptions;

public class userRegisteredException extends Exception {
    public userRegisteredException(){
        super();
    }
    public userRegisteredException(String msg){
        super(msg);
    }
    public userRegisteredException(String msg,Throwable cause){
        super(msg,cause);
    }
    public userRegisteredException(Throwable cause){
        super(cause);
    }
}
