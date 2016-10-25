package com.ad.myheadline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ad.myheadline.R;
import com.ad.myheadline.model.MyNotice;

import java.util.List;

/**
 * Created by AD on 2016/10/11.
 */

public class MyNoticeAdapter extends BaseAdapter{
    private List<MyNotice> myNotices;
    private Context context;

    public MyNoticeAdapter(Context context, List<MyNotice> myNotices) {
        this.context = context;
        this.myNotices = myNotices;
    }
    @Override
    public int getCount() {
        return myNotices.size();
    }

    @Override
    public Object getItem(int position) {
        return myNotices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        convertView = LayoutInflater.from(context).inflate(R.layout.card_notice,null);
        mViewHolder.card_notice_image = (ImageView) convertView.findViewById(R.id.card_notice_image);
        mViewHolder.card_notice_image.setImageResource(myNotices.get(position).getResId());
        mViewHolder.card_notice_title = (TextView)convertView.findViewById(R.id.card_notice_title);
        mViewHolder.card_notice_title.setText(myNotices.get(position).getTitle());
        mViewHolder.card_notice_content = (TextView)convertView.findViewById(R.id.card_notice_content);
        mViewHolder.card_notice_content.setText(myNotices.get(position).getContent());
        return convertView;
    }

    public static class ViewHolder {
        ImageView card_notice_image;
        TextView card_notice_title;
        TextView card_notice_content;
    }
}
