package com.dq.service;

import com.dq.domain.Item;
import com.dq.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private PositionService positionService;
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

    public void getItem(int item_id) {
        Item target=itemMapper.getItemByID(item_id);
        //取东西 发送指令
        //TODO
        itemMapper.getItem(target.getGood_id());
        positionService.reverseStatus(target.getPosition());
    }
}
