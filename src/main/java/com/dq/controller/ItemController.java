package com.dq.controller;

import com.dq.domain.Item;
import com.dq.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public void insertItem(@RequestParam("owner_id")int owner_id,@RequestParam("good_name")String good_name){
        itemService.insertItem(owner_id,good_name);
    }
    @RequestMapping(value="/findByOwnerId",method = RequestMethod.POST)
    public List<Item> findByOwnerId(@RequestParam("owner_id")int owner_id){
        return itemService.findByOwnerId(owner_id);
    }
    @RequestMapping(value="/getItem",method = RequestMethod.POST)
    public void getItem(@RequestParam("item_id")int item_id){
        itemService.getItem(item_id);
    }
}
