package com.ad.myheadline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ad.myheadline.model.MyCard;
import com.ad.myheadline.R;

import java.util.List;

/**
 * Created by AD on 2016/8/20.
 */
public class MyCardAdapter extends BaseAdapter {
    private List<MyCard> myCards;
    private Context mContext;

    public MyCardAdapter(Context mContext,List<MyCard> myCards) {
        this.mContext = mContext;
        this.myCards = myCards;
    }
    @Override
    public int getCount() {
        return myCards.size();
    }

    @Override
    public Object getItem(int position) {
        return myCards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        convertView = LayoutInflater.from(mContext).inflate(R.layout.card_news,null);
        mViewHolder.card_news_title = (TextView)convertView.findViewById(R.id.card_news_title);
        mViewHolder.card_news_title.setText(myCards.get(position).getmTitle());
        mViewHolder.card_news_content = (TextView)convertView.findViewById(R.id.card_news_content);
        mViewHolder.card_news_content.setText(myCards.get(position).getmContent());
        mViewHolder.card_news_date = (TextView)convertView.findViewById(R.id.card_news_date);
        mViewHolder.card_news_date.setText(myCards.get(position).getmDate());
        mViewHolder.card_news_labels = (TextView)convertView.findViewById(R.id.card_news_labels);
        String labels = "";
        for (String label : myCards.get(position).getmLabels()) {
            labels += label + " ";
        }
        mViewHolder.card_news_labels.setText(labels);
        return convertView;
    }

    private static class ViewHolder{
        TextView card_news_title;
        TextView card_news_content;
        TextView card_news_date;
        TextView card_news_labels;
    }
}
