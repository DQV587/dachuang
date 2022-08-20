package com.dq.mapper;

import com.dq.domain.Position;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PositionMapper {
    public Position findAvailablePosition();
    public Position findById(int position_id);
    public void makeTrue(int position_id);
    public void makeFalse(int position_id);
}
