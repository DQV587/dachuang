package com.dq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RosMsg {
    private Values values;
    private boolean result;
    private String service;
    private String op;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Values{
    private String message;
    private boolean success;
}