package com.dq.service;

import com.dq.domain.Car;
import com.dq.mapper.CarMapper;
import com.dq.util.CarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URISyntaxException;

@Service
public class CarService {
    @Autowired
    CarMapper carMapper;
    public Car findCar(){
        Car car=carMapper.findAvailable();
        carMapper.changeStatus(car.getCar_id(), true);
        try {
            CarUtil.activateCar(car);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return car;
    }
    public void moveTo(Car car, int positionX, int positionY){
        try {
            CarUtil.moveCar(car,positionX,positionY);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        CarService car=new CarService();
        try{
            //car.sendMsg("7");
        }catch (Exception e){
            System.out.println("fail");
        }
    }
}


