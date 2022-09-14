package com.dq.service;

import com.dq.domain.JWebSocketClient;
import com.dq.util.JSONutils;
import org.springframework.stereotype.Service;

import java.net.URI;


@Service
public class ArmService {
    private static double normalSpeed = 0.05;
    public static void main(String[] args) {
        String _deviceIp="192.168.149.1";
        URI uri = URI.create("ws://" + _deviceIp + ":9090");
        JWebSocketClient client;
        client = new JWebSocketClient(uri) {
            @Override
            public void onMessage(String message) {
                //message就是接收到的消息
                System.out.println(message);
            }
        };
        try {
            client.connectBlocking();
            //进入玩法
            if (client != null && client.isOpen()) {
//                client.send(JSONutils.send("call_service", "remote_control/enter"));
                for (int i=0;i<100;i++){
                    client.send(JSONutils.arm_move_data("/jetmax/relative_command", 0, 5, 0, normalSpeed));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
