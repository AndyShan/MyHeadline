package com.ad.myheadline.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.ad.myheadline.R;
import com.ad.myheadline.model.NewsLab;
import com.ad.myheadline.network.ApiRequest;
import com.tt.whorlviewlibrary.WhorlView;

/**
 * Created by AD on 2016/8/30.
 */
public class UploadActivity extends AppCompatActivity {
    private Boolean FLAG = false;
    private FloatingActionButton fab;
    private WhorlView whorlView;
    private EditText title_edittext;
    private EditText content_edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        title_edittext = (EditText)findViewById(R.id.title_edittext);
        content_edittext = (EditText)findViewById(R.id.content_edittext);
        fab = (FloatingActionButton)findViewById(R.id.upload_fab);
        whorlView = (WhorlView)findViewById(R.id.upload_whorl);
        whorlView.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = title_edittext.getText().toString() + " " + content_edittext.getText().toString();
                if (FLAG == true) {
                    whorlView.stop();
                    whorlView.setVisibility(View.INVISIBLE);
                    FLAG = false;
                } else {
                    whorlView.start();
                    whorlView.setVisibility(View.VISIBLE);
                    Runnable r = new ApiRequest(1, keyword);
                    Thread t = new Thread(r);
                    t.start();
                    FLAG = true;
                }
            }
        });
    }
}
