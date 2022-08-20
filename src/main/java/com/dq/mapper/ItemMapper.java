package com.dq.mapper;

import com.dq.domain.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemMapper {

    public void insertItem(Item item);
    public void getItem(int good_id);
    public List<Item> getAllItems();
    public List<Item> getItemsByOwnerID(int owner_id);
    public Item getItemByID(int item_id);
}
