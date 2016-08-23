package com.ad.myheadline.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ad.myheadline.R;
import com.ad.myheadline.adapter.MyCardAdapter;
import com.ad.myheadline.network.ApiRequest;


public class HotPageFragment extends Fragment
{
    private TextView mText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragmet_hot_page,container,false);
        mText = (TextView)view.findViewById(R.id.mtext);
        return view;
    }

}