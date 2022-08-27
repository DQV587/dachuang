package com.dq.domain.wx_login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeChatModel {
    private String code;
    private String avatarUrl;
    private String nickName;
    private String openId;

}
