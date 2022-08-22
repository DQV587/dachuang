package com.dq.exceptions;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException(){
        super();
    }
    public ItemNotFoundException(String msg){
        super(msg);
    }
    public ItemNotFoundException(String msg,Throwable cause){
        super(msg,cause);
    }
    public ItemNotFoundException(Throwable cause){
        super(cause);
    }
}
