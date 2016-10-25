package com.ad.myheadline.model;

/**
 * Created by AD on 2016/10/11.
 */

public class MyNotice {
    private String title;
    private String content;
    private int resId;
    public MyNotice(String title, String content, int resId) {
        this.title = title;
        this.content = content;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
