package com.ad.myheadline.model;

/**
 * Created by AD on 2016/10/8.
 */

public class MyClas {
    private String name;
    private String url;
    private int resId;
    public MyClas(String name, String url, int resId) {
        this.name = name;
        this.url = url;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
