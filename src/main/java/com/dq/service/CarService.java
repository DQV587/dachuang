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
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
        car.setStatus(true);
        return car;
    }
    public Car findCarById(int car_id){
        return carMapper.findById(car_id);
    }
    public void closeCar(Car car) throws URISyntaxException, IOException {
        if(car.isStatus()){
            carMapper.changeStatus(car.getCar_id(), false);
            CarUtil.inactivateCar(car);
        }
    }
    public void updatePosition(Car car,int positionX,int positionY){
        carMapper.updatePosition(car.getCar_id(), positionX,positionY);
    }
    public void moveTo(Car car, int positionX, int positionY) throws URISyntaxException, IOException {
            CarUtil.moveCar(car,positionX,positionY);
    }

    public static void main(String[] args){
        Car car;
        Car car1=new Car(1,0,0,"192.168.43.148",false);
        try {
            CarUtil.activateCar(car1);
            CarUtil.moveCar(car1,2,1);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


