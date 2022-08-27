package com.dq.domain.wx_login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeChatSession {
    private String openid;
    private String session_key;
    private String errcode;
    private String errmsg;
}
