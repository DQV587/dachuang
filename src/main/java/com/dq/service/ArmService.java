package com.dq.service;

import com.dq.domain.JWebSocketClient;
import com.dq.domain.RosMsg;
import com.dq.util.JSONutils;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.net.URI;



public class ArmService {
    private String _deviceIp;
    private JWebSocketClient client;
    public ArmService(String _deviceIp){
        this._deviceIp=_deviceIp;
        URI uri = URI.create("ws://" + _deviceIp + ":9090");
        this.client = new JWebSocketClient(uri) {
            @Override
            public void onMessage(String message) {
                //message就是接收到的消息m
                Gson gson=new Gson();
                RosMsg msg=gson.fromJson(message,RosMsg.class);
                System.out.println(msg);
            }
        };
    }
    public void close() throws InterruptedException {
        this.client.closeBlocking();
    }
    public void grab(){
        try {
            client.connectBlocking();
        } catch (IllegalStateException e) {
            try {
                client.reconnectBlocking();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (client.isOpen()) {
            client.send(JSONutils.send("call_service","palletizing/enter"));
            client.send(JSONutils.send_data("call_service", "palletizing/set_running","true"));
        }
    }
    public void release(){
        try {
            client.connectBlocking();
        } catch (IllegalStateException e) {
            try {
                client.reconnectBlocking();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (client != null && client.isOpen()) {
            client.send(JSONutils.send_data("call_service", "palletizing/set_running","false"));
        }
    }
    public static void main(String[] args) {
        ArmService armService=new ArmService("192.168.43.54");
//        armService.grab();
//
//        try {
//            Thread.sleep(12000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        armService.release();
        try {
            armService.close();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
