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
    public Result insertItem(@RequestParam("car_id")int car_id,@RequestParam("curX")int curX,
                             @RequestParam("curY")int curY,@RequestParam("status")String status){
        System.out.println("receiveMsg");
        System.out.println("id:"+car_id+"curX:"+curX+"curY:"+curY+"status:"+status);
        return Result.success(null,null);
    }
}
