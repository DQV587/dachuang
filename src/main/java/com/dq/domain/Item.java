package com.dq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private int good_id;
    private int owner_id;
    private int position;
    private boolean taken;
    private String good_name;
}
