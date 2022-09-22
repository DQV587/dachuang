package com.dq.service;

import com.dq.domain.Car;
import com.dq.domain.Item;
import com.dq.domain.Position;
import com.dq.exceptions.ItemNotFoundException;
import com.dq.mapper.ItemMapper;
import com.dq.util.CarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private PositionService positionService;
    @Autowired
    private CarService carService;
    public void insertItem(int owner_id, String good_name) {
        int position=positionService.findAvailable().getPosition_id();
        itemMapper.insertItem(new Item(1,owner_id,position,false,good_name));
        positionService.reverseStatus(position);
    }
    public List<Item> findAll(){
        return itemMapper.getAllItems();
    }
    public List<Item> findByOwnerId(int owner_id) {
        return itemMapper.getItemsByOwnerID(owner_id);
    }
    public Item findById(int item_id){
        Item target=itemMapper.getItemByID(item_id);
        return target;
    }
    public void getItem(Item target)  {
        //取东西 发送指令
        Car car=carService.findCar();
        try {
            CarUtil.activateCar(car);
            Position position=positionService.findById(target.getPosition());
            CarUtil.moveCar(car,position.getX(), position.getY());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        itemMapper.getItem(target.getGood_id());
        positionService.reverseStatus(target.getPosition());
    }
}
