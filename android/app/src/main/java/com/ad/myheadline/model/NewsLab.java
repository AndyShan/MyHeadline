package com.ad.myheadline.model;

/**
 * Created by AD on 2016/8/23.
 */
public class NewsLab {
    private static NewsLab newsLab;
    private MyCard[] myCards;
    private String keywordQureyResult;
    private String keyword;


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

    public String getKeywordQureyResult() {
        return keywordQureyResult;
    }

    public void setKeywordQureyResult(String keywordQureyResult) {
        this.keywordQureyResult = keywordQureyResult;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
