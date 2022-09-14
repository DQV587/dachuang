package com.dq.service;

import com.dq.domain.Car;
import com.dq.mapper.CarMapper;
import com.dq.util.CarUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class CarService {
    @Autowired
    CarMapper carMapper;
    String host = "192.168.43.148";
    int port = 80;
    public Car findACar(){
        Car car=carMapper.findAvailable();
        carMapper.changeStatus(car.getCar_id(), true);
        try {
            CarUtil.activateCar(car);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return car;
    }
    public void moveTo(Car car, int positionX, int positionY){
        try {
            CarUtil.moveCar(car,positionX,positionY);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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


