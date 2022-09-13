package com.dq.controller;

import com.dq.domain.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Car")
public class CarController {
    @RequestMapping(value = "/recMsg",method = RequestMethod.GET)
    public Result insertItem(@RequestParam("msg")String msg){
        System.out.println("receiveMsg");
        System.out.println(msg);
        return Result.success(null,null);
    }
}
