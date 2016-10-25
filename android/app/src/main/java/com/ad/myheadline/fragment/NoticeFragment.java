package com.ad.myheadline.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ad.myheadline.R;
import com.ad.myheadline.adapter.MyNoticeAdapter;
import com.ad.myheadline.model.MyNotice;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AD on 2016/10/11.
 */

public class NoticeFragment extends ListFragment{
    private MyNoticeAdapter myNoticeAdapter;
    private List<MyNotice> myNotices;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice, container,false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myNotices = getItems();
        myNoticeAdapter = new MyNoticeAdapter(getActivity(), myNotices);
        setListAdapter(myNoticeAdapter);

    }


    private List<MyNotice> getItems() {
        List<MyNotice> myCards = new ArrayList<MyNotice>();
        myCards.add(new MyNotice("学生创新实践中心","请到二楼集合",R.drawable.card_notice_0));
        myCards.add(new MyNotice("天津理工大学","奖学金评定开始了，请同学们将申请发到邮箱",R.drawable.card_notice_1));
        return myCards;
    }

}
