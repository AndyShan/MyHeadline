package com.ad.myheadline.model;

import java.util.ArrayList;

/**
 * Created by AD on 2016/8/20.
 */
public class MyCard {
    private String mTitle;
    private String mContent;
    private String mDate;
    private ArrayList<String> mLabels;
    public MyCard(String mTitle,String mContent,String mDate,ArrayList<String> mLabels) {
        this.mTitle = mTitle;
        this.mContent = mContent;
        this.mDate = mDate;
        this.mLabels = mLabels;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public ArrayList<String> getmLabels() {
        return mLabels;
    }

    public void setmLabels(ArrayList<String> mLabels) {
        this.mLabels = mLabels;
    }
}
