package com.dq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T>  {

    private boolean flag;
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success(String msg,T data){
        Result<T> result = new Result<>();
        result.setFlag(true);
        result.setCode(200);
        result.setMsg(msg);
        result.setData(data);
        return result;

    }

    public static <T> Result<T> fail(Integer code,String msg){
        Result<T> result = new Result<>();
        result.setFlag(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
