package com.ad.myheadline.network;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.ad.myheadline.model.NewsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by AD on 2016/8/23.
 */
public class ApiRequest extends Activity implements Runnable {

    private int api_code;
    private String keyword;
    public ApiRequest(int api_code,String keyword) {
        this.api_code = api_code;
        this.keyword = keyword;
    }
    @Override
    public void run() {
        if (api_code == 0) {
            String s = null;

            try {
                s = getRequestKeyWord(keyword);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            NewsLab.get().setKeywordQureyResult(s);
        }
    }

    /*
    发送获取keyword信息的get请求
     */
    private String getRequestKeyWord(String keyword) throws UnsupportedEncodingException {
        String result = "";
        if (keyword != null) {
            String url = "http://192.168.199.184:5000/api/v1.0/keyword/" + URLEncoder.encode(keyword.trim(), "utf-8").replace("+","%20");
            Log.d("url",url);
            result = getRequest(url);
        }
        return result;
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
            Log.d("error","发送get请求出错");
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
        Log.d("result",result);
        return result;
    }


}
