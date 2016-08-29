package com.ad.myheadline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ad.myheadline.model.MyCard;
import com.ad.myheadline.R;
import com.ad.myheadline.model.MyLabel;

import java.util.List;

/**
 * Created by AD on 2016/8/20.
 */
public class MyLabelAdapter extends BaseAdapter {
    private List<MyLabel> myLabels;
    private Context mContext;

    public MyLabelAdapter(Context mContext,List<MyLabel> myLabels) {
        this.mContext = mContext;
        this.myLabels = myLabels;
    }
    @Override
    public int getCount() {
        return myLabels.size();
    }

    @Override
    public Object getItem(int position) {
        return myLabels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        convertView = LayoutInflater.from(mContext).inflate(R.layout.card_labels,null);
        mViewHolder.mImageView = (ImageView)convertView.findViewById(R.id.labels_photo);
        mViewHolder.mTextView = (TextView)convertView.findViewById(R.id.label_name);
        mViewHolder.mTextView.setText(myLabels.get(position).getMyLabelName());
        mViewHolder.mImageView.setImageResource(myLabels.get(position).getmPic());
        return convertView;
    }

    private static class ViewHolder{
        ImageView mImageView;
        TextView mTextView;
    }
}
