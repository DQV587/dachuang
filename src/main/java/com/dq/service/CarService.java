package com.dq.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class CarService {
    String host = "192.168.43.148";
    int port = 80;
    public void sendMsg(String msg) throws IOException, URISyntaxException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost(host)
                .setPath("/sendMsg")
                .setParameter("position", msg)
                .build();
        HttpGet httpGet = new HttpGet(uri);
        //response 对象
        CloseableHttpResponse response = null;
        try {
            // 执行http get请求
           response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println("success");
                }
            } finally {
            if (response != null) {
                response.close();
                }
            httpclient.close();
            }

//        Socket socket = null;
//        try {
//            //创建套接字,套接字是传输层Tcp像应用层Http开的一个编程接口，开发人员主要是通过套接字对tcp进行编程
//            socket = new Socket(host,port);
//            //向服务端发起一个请求，通过socket创建io输出流
//            OutputStream outputStream = socket.getOutputStream();
//            //通过io输出流创建数据输出流
//            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//            dataOutputStream.writeUTF(msg);
//            //通过socket创建io输入流
//            InputStream inputStream = socket.getInputStream();
//            //通过io输入流创建数据输入流
//            DataInputStream dataInputStream = new DataInputStream(inputStream);
//            //接收服务端的响应
//            String s = dataInputStream.readUTF();
//            System.out.println("客户端接收到的数据：[ " + s + " ]");
//            //关闭数据传输流
//            dataOutputStream.close();
//            dataInputStream.close();
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    public static void main(String[] args){
        CarService car=new CarService();
        try{
            car.sendMsg("7");
        }catch (Exception e){
            System.out.println("fail");
        }
    }
}


