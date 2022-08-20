package com.dq.domain;

import com.dq.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public Result<String> arithmeticException(Exception e){
        log.error("全局异常信息 ex={}",e.getMessage(),e );
        return Result.fail(50000,e.getMessage());
    }
    @ExceptionHandler(UserNotFoundException.class)
    public Result<Object> userNotFoundException(Exception e){
        log.error("全局异常信息 ex={}",e.getMessage(),e );
        return Result.fail(50000,e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public Result<String> Exception(Exception e){
        log.error("全局异常信息 ex={}",e.getMessage(),e );
        return Result.fail(50000,"未知异常请联系管理员");
    }
}