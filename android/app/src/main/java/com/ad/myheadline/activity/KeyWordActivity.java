package com.ad.myheadline.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.ad.myheadline.R;
import com.ad.myheadline.adapter.KeyWordAdapter;
import com.ad.myheadline.adapter.RecommendWordAdapter;
import com.ad.myheadline.model.KeyWord;
import com.ad.myheadline.model.NewsLab;

import java.util.ArrayList;
import java.util.List;

public class KeyWordActivity extends AppCompatActivity {
    private EditText mEditText;
    private Button mButton;
    private ListView mKeyWordListView;
    private ListView mRecommendListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyword);
        mEditText = (EditText)findViewById(R.id.edit_keyword);
        mButton = (Button)findViewById(R.id.add_keyword);
        mKeyWordListView = (ListView)findViewById(R.id.list_keyword);
        mRecommendListView = (ListView)findViewById(R.id.list_recommend);

        RecommendWordAdapter rcAdapter = new RecommendWordAdapter(this,initRecommendWord());
        mRecommendListView.setAdapter(rcAdapter);
        initKeyWord();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences share = getSharedPreferences("keyword", Context.MODE_PRIVATE);
                String keyword = share.getString("word","");
                keyword = mEditText.getText().toString() + " " + keyword;
                SharedPreferences.Editor editor = share.edit();
                editor.putString("word",keyword);
                editor.commit();
                mEditText.setText("");
                initKeyWord();
            }
        });
        mKeyWordListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                KeyWord word = (KeyWord)mKeyWordListView.getItemAtPosition(position);
                showDialog(word.getWord());
            }
        });
    }

    private void initKeyWord() {
        SharedPreferences share = getSharedPreferences("keyword",Context.MODE_PRIVATE);
        String word = share.getString("word","");
        NewsLab.get().setKeyword(word);
        String[] words = word.split(" ");
        List<KeyWord> mWords = new ArrayList<>();
        for (String i : words) {
            if (i != "" && i != " ") {
                mWords.add(new KeyWord(i));
            }
        }
        KeyWordAdapter adapter = new KeyWordAdapter(this,mWords);
        mKeyWordListView.setAdapter(adapter);
    }
    private List<KeyWord> initRecommendWord() {
        List<KeyWord> mWords = new ArrayList<>();
        mWords.add(new KeyWord("机器学习"));
        mWords.add(new KeyWord("大数据"));
        mWords.add(new KeyWord("人工智能"));
        mWords.add(new KeyWord("云计算"));
        mWords.add(new KeyWord("数据挖掘"));
        return mWords;
    }
    private void showDialog(final String word) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("确定删除关键字");
        builder.setMessage("不在关注" + word + "?");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences share = getSharedPreferences("keyword",Context.MODE_PRIVATE);
                String words = share.getString("word","");
                String[] wordarr = words.split(" ");
                String newWords = "";
                for (String i : wordarr) {
                    if (!word.contains(i)) {
                        newWords = i + " " + newWords;
                    }
                }
                SharedPreferences.Editor editor = share.edit();
                editor.remove("word");
                editor.putString("word",newWords);
                editor.commit();
                initKeyWord();
            }
        });
        builder.show();
    }
}
