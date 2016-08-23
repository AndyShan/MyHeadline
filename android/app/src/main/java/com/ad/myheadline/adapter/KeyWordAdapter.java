package com.ad.myheadline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ad.myheadline.model.KeyWord;
import com.ad.myheadline.R;

import java.util.List;

/**
 * Created by AD on 2016/8/21.
 */
public class KeyWordAdapter extends BaseAdapter {
    private List<KeyWord> mKeyWords;
    private Context mContext;
    public KeyWordAdapter(Context mContext,List<KeyWord> mKeyWords) {
        this.mContext = mContext;
        this.mKeyWords = mKeyWords;
    }
    @Override
    public int getCount() {
        return mKeyWords.size();
    }

    @Override
    public Object getItem(int position) {
        return mKeyWords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        convertView = LayoutInflater.from(mContext).inflate(R.layout.list_keyword,null);
        mViewHolder.textView = (TextView)convertView.findViewById(R.id.my_textview);
        mViewHolder.textView.setText(mKeyWords.get(position).getWord());
        return convertView;
    }
    private static class ViewHolder {
        TextView textView;
    }
}
