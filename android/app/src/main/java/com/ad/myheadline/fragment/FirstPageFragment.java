package com.ad.myheadline.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.ad.myheadline.model.MyCard;
import com.ad.myheadline.adapter.MyCardAdapter;
import com.ad.myheadline.R;
import com.ad.myheadline.model.NewsLab;
import com.ad.myheadline.network.ApiRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AD on 2016/8/21.
 */
public class FirstPageFragment extends ListFragment {
    private ListView myListView;
    private MyCardAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_page, container,false);
        myListView = (ListView) view.findViewById(android.R.id.list);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myAdapter = new MyCardAdapter(getActivity(),getItems());
        setListAdapter(myAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l,v,position,id);
        System.out.print(l.getChildAt(position));
    }
    /*
    初始化获取每一个item的方法
    TODO:网络请求获取信息
     */
    private List<MyCard> getItems() {
        List<MyCard> myCards = new ArrayList<MyCard>();
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("label1");
        labels.add("label2");
        labels.add("label3");
        for (int i = 0;i < 1; i++) {
            MyCard card = new MyCard("Title" + i,"content\ncontent\ncontent","2016/8/20",labels);
            myCards.add(card);
        }
        String text = "1";
        Runnable r = new ApiRequest(0);
        Thread t = new Thread(r);
        t.start();

        MyCard card2 = new MyCard("T", NewsLab.get().getS(),"2",labels);
        myCards.add(card2);
        return myCards;
    }
}
