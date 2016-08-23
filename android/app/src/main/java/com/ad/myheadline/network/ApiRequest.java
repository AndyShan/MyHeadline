package com.ad.myheadline.network;


import android.util.Log;

import com.ad.myheadline.model.NewsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by AD on 2016/8/23.
 */
public class ApiRequest implements Runnable {

    private int api_code;
    public ApiRequest(int api_code) {
        this.api_code = api_code;
    }
    @Override
    public void run() {
        if (api_code == 0) {
            String s = getRequest("http://192.168.1.104:5000/api/v1.0/keyword/%E5%BC%A0%E7%BB%A7%E7%A7%91");
//TODO:获得信息后更新NewsLab单例。
            Log.d("s",s);
            NewsLab.get().setS(s);
        }
    }

    /*
    发送获取keyword信息的get请求
    TODO:不同形式的get请求
     */
    private String getRequestKeyWord(String keyword) {
        return null;
    }

    /*
    发送get请求
     */
    private String getRequest(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);//将搜索内容拼接搜索get请求转成URL类
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();//定义链接
            connection.connect();//开始链接
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line + "\n";//注：不加\n正则匹配可能会出错
            }
        } catch (Exception e) {//异常处理
            System.out.println("发送get请求出错");
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
