package com.dq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private int car_id;
    private int positionX;
    private int positionY;
    private String ip_address;
    private boolean status;
}
