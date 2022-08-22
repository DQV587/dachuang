package com.dq.exceptions;

public class passwordIncorrectException extends Exception {
    public passwordIncorrectException(){
        super();
    }
    public passwordIncorrectException(String msg){
        super(msg);
    }
    public passwordIncorrectException(String msg,Throwable cause){
        super(msg,cause);
    }
    public passwordIncorrectException(Throwable cause){
        super(cause);
    }
}
