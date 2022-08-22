package com.dq.domain;

import com.dq.exceptions.ItemNotFoundException;
import com.dq.exceptions.UserNotFoundException;
import com.dq.exceptions.passwordIncorrectException;
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
        return Result.fail(500,e.getMessage());
    }
    @ExceptionHandler(ItemNotFoundException.class)
    public Result<Object> itemNotFoundException(Exception e){
        log.error("全局异常信息 ex={}",e.getMessage(),e );
        return Result.fail(501,e.getMessage());
    }
    @ExceptionHandler(passwordIncorrectException.class)
    public Result<Object> passwordIncorrectException(Exception e){
        log.error("全局异常信息 ex={}",e.getMessage(),e );
        return Result.fail(502,e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public Result<String> Exception(Exception e){
        log.error("全局异常信息 ex={}",e.getMessage(),e );
        return Result.fail(50000,"未知异常请联系管理员");
    }
}