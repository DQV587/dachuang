package com.dq.controller;

import com.dq.domain.Result;
import com.dq.domain.wx_login.WeChatModel;
import com.dq.domain.wx_login.WeChatSession;
import com.dq.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/WX")
public class WxController {
    private static final String APPID= "****************";
    private static final String APPSECRET = "****************";
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody WeChatModel weChatModel){
        WeChatSession weChatSession;

        //微信服务器的接口路径
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+ "&secret="+APPSECRET+"&js_code="+ weChatModel.getCode() +"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        //进行网络请求,访问微信服务器接口
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        //根据返回值进行后续操作

        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            String sessionData = responseEntity.getBody();
            Gson gson = new Gson();
            //将json字符串转化为实体类;
            weChatSession = gson.fromJson(sessionData, WeChatSession.class);
        }
        return null;
        //TODO
//        try{
//            if (openid == null || session_key == null){
//                return Result.fail(Integer.valueOf(errcode),errmsg);
//            }
//            WxUser user = userService.login(openid);
//            if(EmptyUtil.isEmpty(user)){
//                weChatModel.setOpenId(openid);
//                boolean flag = userService.insertUser(weChatModel);
//                if(flag == true){
//                    return Result.success(weChatModel);
//                }
//                else {
//                    return Result.error("用户login失败！");
//                }
//            }
//            else{
//                return Result.success(user);
//            }
//        } catch (MyException e) {
//            return Result.error(e.getCode(), e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            e.printStackTrace();
//            return Result.error(ResultEnum.UNKONW_ERROR.getCode(), "添加用户信息Exception");
//        }
    }
}
