package com.dq.controller;

import com.dq.domain.Item;
import com.dq.domain.Result;
import com.dq.exceptions.ItemNotFoundException;
import com.dq.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Item")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ThreadPoolTaskExecutor executor;
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Result insertItem(@RequestParam("owner_id")int owner_id,@RequestParam("good_name")String good_name){
        executor.execute(()->itemService.insertItem(owner_id, good_name));
        return new Result(true,200,null,null);
    }
    @RequestMapping(value="/findByOwnerId",method = RequestMethod.POST)
    public Result findByOwnerId(@RequestParam("owner_id")int owner_id){
        return new Result<>(true,200,null,itemService.findByOwnerId(owner_id));
    }
    @RequestMapping(value="/getItem",method = RequestMethod.POST)
    public Result getItem(@RequestParam("item_id")int item_id) throws ItemNotFoundException {
        Item target=itemService.findById(item_id);
        if(target==null)
            return new Result<>(true,200,null,false);
        executor.execute(()->itemService.getItem(target));
        return new Result<>(true,200,null,true);
    }
    @RequestMapping(value="/findAll",method = RequestMethod.POST)
    public Result findAll()  {
        return new Result<>(true,200,null,itemService.findAll());
    }
}
