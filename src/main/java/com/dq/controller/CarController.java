package com.dq.controller;

import com.dq.domain.Car;
import com.dq.domain.Result;
import com.dq.service.ArmService;
import com.dq.service.CarService;
import com.dq.util.CarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/Car")
public class CarController {
    @Autowired
    private CarService carService;
    private ArmService armService=new ArmService("192.168.43.54");
    @RequestMapping(value = "/recMsg",method = RequestMethod.GET)
    public Result arriveTarget(@RequestParam("car_id")int car_id,@RequestParam("curX")int curX,
                             @RequestParam("curY")int curY,@RequestParam("status")String status){
        System.out.println("id:"+car_id+"curX:"+curX+"curY:"+curY+"status:"+status);
        Car car=carService.findCarById(car_id);
        carService.updatePosition(car,curX,curY);
        boolean Status= status.equals("true");
        if(Status){
            armService.grab();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                armService.close();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                carService.moveTo(car,2,0);
            } catch (URISyntaxException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            armService.release();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                armService.close();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                carService.closeCar(car);
            } catch (URISyntaxException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Result.success(null,null);
    }
}
