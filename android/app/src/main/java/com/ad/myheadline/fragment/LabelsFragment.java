package com.ad.myheadline.fragment;

import android.app.IntentService;
import android.app.ListFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.ad.myheadline.adapter.MyLabelAdapter;
import com.ad.myheadline.model.MyCard;
import com.ad.myheadline.adapter.MyCardAdapter;
import com.ad.myheadline.R;
import com.ad.myheadline.model.MyLabel;
import com.ad.myheadline.model.NewsLab;
import com.ad.myheadline.network.ApiRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AD on 2016/8/21.
 */
public class LabelsFragment extends ListFragment {
    private ListView myListView;
    private MyLabelAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_labels, container,false);
        myListView = (ListView) view.findViewById(android.R.id.list);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<MyLabel> myLabels = getItems();
        myAdapter = new MyLabelAdapter(getActivity(),myLabels);
        setListAdapter(myAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l,v,position,id);
    }
    /*
    初始化获取每一个item的方法
     */
    private List<MyLabel> getItems() {
        List<MyLabel> myLabels = new ArrayList<MyLabel>();
        myLabels.add(new MyLabel("财经",R.drawable.card_test));
        myLabels.add(new MyLabel("娱乐",R.drawable.card_test2));
        myLabels.add(new MyLabel("时尚",R.drawable.card_test3));
        return myLabels;
    }



    /*
    解析Unicode
     */
    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 0; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i],16);
            string.append((char)data);
        }
        return string.toString();
    }
}
