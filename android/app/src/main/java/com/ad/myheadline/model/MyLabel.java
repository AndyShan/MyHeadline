package com.ad.myheadline.model;

/**
 * Created by AD on 2016/8/29.
 */
public class MyLabel {
    private String myLabelName;
    private int mPic;

    public MyLabel(String myLabelName,int mPic) {
        this.myLabelName = myLabelName;
        this.mPic = mPic;
    }

    public int getmPic() {
        return mPic;
    }

    public void setmPic(int mPic) {
        this.mPic = mPic;
    }

    public String getMyLabelName() {
        return myLabelName;
    }

    public void setMyLabelName(String myLabelName) {
        this.myLabelName = myLabelName;
    }
}
