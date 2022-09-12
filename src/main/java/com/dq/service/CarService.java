package com.dq.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.net.Socket;
@Service
public class CarService {
    String host = "192.168.43.148";
    int port = 80;
    public void sendMsg(String msg) {
        Socket socket = null;
        try {
            //创建套接字,套接字是传输层Tcp像应用层Http开的一个编程接口，开发人员主要是通过套接字对tcp进行编程
            socket = new Socket(host,port);
            //向服务端发起一个请求，通过socket创建io输出流
            OutputStream outputStream = socket.getOutputStream();
            //通过io输出流创建数据输出流
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(msg);
            //通过socket创建io输入流
            InputStream inputStream = socket.getInputStream();
            //通过io输入流创建数据输入流
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            //接收服务端的响应
            String s = dataInputStream.readUTF();
            System.out.println("客户端接收到的数据：[ " + s + " ]");
            //关闭数据传输流
            dataOutputStream.close();
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        CarService car=new CarService();
        car.sendMsg("hello");
    }
}


