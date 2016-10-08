package com.ad.myheadline.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ad.myheadline.R;
import com.ad.myheadline.adapter.MyCardAdapter;
import com.ad.myheadline.adapter.MyClasAdapter;
import com.ad.myheadline.model.MyClas;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AD on 2016/10/8.
 */

public class ClasFragment extends ListFragment {
    private ListView myListView;
    private MyClasAdapter myClasAdapter;
    private List<MyClas> myClases;


    private onClasPageCallBack mCallBack;
    public interface onClasPageCallBack {
        void onClasCallBack(MyClas clas);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clas, container,false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myClases = getItems();;
        myClasAdapter = new MyClasAdapter(getActivity(), myClases);
        setListAdapter(myClasAdapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallBack  = (onClasPageCallBack) getActivity();
        mCallBack.onClasCallBack(myClases.get(position));
    }

    private List<MyClas> getItems() {
        List<MyClas> myClases = new ArrayList<>();
        myClases.add(new MyClas("娱乐","http://mil.sina.cn/?vt=4&pos=3",R.drawable.clas_1));
        myClases.add(new MyClas("娱乐","http://baidu.com",R.drawable.clas_1));
        myClases.add(new MyClas("娱乐","http://mil.sina.cn/?vt=4&pos=3",R.drawable.clas_1));
        myClases.add(new MyClas("娱乐","http://mil.sina.cn/?vt=4&pos=3",R.drawable.clas_1));
        myClases.add(new MyClas("娱乐","http://mil.sina.cn/?vt=4&pos=3",R.drawable.clas_1));
        return myClases;
    }


}
