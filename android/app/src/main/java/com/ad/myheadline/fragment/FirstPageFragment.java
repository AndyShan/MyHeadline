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

import com.ad.myheadline.model.MyCard;
import com.ad.myheadline.adapter.MyCardAdapter;
import com.ad.myheadline.R;
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
        Log.d("onCeate","True");
        super.onCreate(savedInstanceState);
        try {
            List<MyCard> myCards = getItems();
            Log.d("size",myCards.size() + "");
            myAdapter = new MyCardAdapter(getActivity(),myCards);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setListAdapter(myAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l,v,position,id);
        System.out.print(l.getChildAt(position));
    }
    /*
    初始化获取每一个item的方法
     */
    private List<MyCard> getItems() throws JSONException {
        List<MyCard> myCards = new ArrayList<MyCard>();
        Log.d("get","true");
        Runnable r = new ApiRequest(0,NewsLab.get().getKeyword());
        Thread t = new Thread(r);
        t.start();

        String content = NewsLab.get().getKeywordQureyResult();
        if (content != "" && content != null) {
            JSONArray jsonArray = new JSONArray(content);
            for (int i = jsonArray.length() - 1; i >= 0; i--) {
                JSONObject ob = jsonArray.getJSONObject(i);
                ArrayList<String> labels = new ArrayList();
                JSONArray labelArray = ob.getJSONArray("labels");
                for (int j = 0;j < 3; j++) {
                    labels.add(labelArray.getString(j));
                }
                MyCard card = new MyCard("新闻",ob.getString("title"),ob.getString("time"),labels,ob.getString("href"));
                myCards.add(card);

            }
        }
        return myCards;
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
