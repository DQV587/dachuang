package com.dq.service;

import com.dq.domain.Position;
import com.dq.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    @Autowired
    private PositionMapper positionMapper;

    public Position findAvailable(){
        return positionMapper.findAvailablePosition();
    }

    public void reverseStatus(int position_id){
        Position target=positionMapper.findById(position_id);
        if(target.isHas_good()){
            positionMapper.makeFalse(position_id);
        }
        else positionMapper.makeTrue(position_id);
    }
}
