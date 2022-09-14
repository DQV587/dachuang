package com.dq.mapper;

import com.dq.domain.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CarMapper {
    public void updatePosition(int car_id,int positionX,int positionY);
    public Car findById(int car_id);
    public boolean lookUpStatus(int car_id);
    public void changeStatus(int car_id,boolean status);
    public Car findAvailable();
}
