package com.dq.exceptions;

public class managerNotFoundException extends Exception {
    public managerNotFoundException(){
        super();
    }
    public managerNotFoundException(String msg){
        super(msg);
    }
    public managerNotFoundException(String msg,Throwable cause){
        super(msg,cause);
    }
    public managerNotFoundException(Throwable cause){
        super(cause);
    }
}
