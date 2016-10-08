package com.ad.myheadline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ad.myheadline.R;
import com.ad.myheadline.model.MyClas;

import java.util.List;

/**
 * Created by AD on 2016/10/8.
 */

public class MyClasAdapter extends BaseAdapter {
    private List<MyClas> myClases;
    private Context mContext;

    public MyClasAdapter(Context mContext,List<MyClas> myClases) {
        this.mContext = mContext;
        this.myClases = myClases;
    }
    @Override
    public int getCount() {
        return myClases.size();
    }

    @Override
    public Object getItem(int position) {
        return myClases.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        convertView = LayoutInflater.from(mContext).inflate(R.layout.card_clas,null);
        mViewHolder.card_clas_image = (ImageView) convertView.findViewById(R.id.card_clas_image);
        mViewHolder.card_clas_image.setImageResource(myClases.get(position).getResId());
        mViewHolder.card_clas_name = (TextView)convertView.findViewById(R.id.card_clas_name);
        mViewHolder.card_clas_name.setText(myClases.get(position).getName());
        return convertView;
    }

    private static class ViewHolder{
        TextView card_clas_name;
        ImageView card_clas_image;
    }
}
