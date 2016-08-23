package com.ad.myheadline.model;

/**
 * Created by AD on 2016/8/23.
 */
public class NewsLab {
    private static NewsLab newsLab;
    private MyCard[] myCards;
    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    private NewsLab() {

    };
    public static NewsLab get() {
        if (newsLab == null) {
            newsLab = new NewsLab();
        }
        return newsLab;
    }

    public MyCard[] getMyCards() {
        return myCards;
    }

    public void setMyCards(MyCard[] myCards) {
        this.myCards = myCards;
    }
}
