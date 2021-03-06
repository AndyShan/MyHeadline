package com.ad.myheadline.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ad.myheadline.R;
import com.ad.myheadline.fragment.ClasFragment;
import com.ad.myheadline.fragment.FirstPageFragment;
import com.ad.myheadline.fragment.NoticeFragment;
import com.ad.myheadline.model.MyCard;
import com.ad.myheadline.model.MyClas;
import com.ad.myheadline.model.NewsLab;
import com.srx.widget.TabBarView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,FirstPageFragment.onFirstPageCallBack, ClasFragment.onClasPageCallBack{
    private FirstPageFragment firstPageFragment;
    private ClasFragment clasFragment;
    private NoticeFragment noticeFragment;
    private TabBarView mTabBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences share = getSharedPreferences("keyword", Context.MODE_PRIVATE);
        NewsLab.get().setKeyword(share.getString("word",""));

        setDefaultFragment();

        initTabBarView();

        mTabBarView.setOnTabBarClickListener(initTabBarClickListener());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_keyword) {
            Intent i = new Intent(MainActivity.this,KeyWordActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(MainActivity.this,UploadActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            Intent i = new Intent(MainActivity.this,ScrollingActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setDefaultFragment() {
        firstPageFragment = new FirstPageFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content,firstPageFragment).commit();
    }

    private void initTabBarView() {
        mTabBarView = (TabBarView)findViewById(R.id.tabBarView);
        mTabBarView.setMainBitmap(R.drawable.plus_icon);
        mTabBarView.bindBtnsForPage(0, R.drawable.nearby_icon, R.drawable.refresh_icon, R.drawable.edit_icon);
        mTabBarView.bindBtnsForPage(1, R.drawable.profile_icon, R.drawable.edit_icon, 0);
        mTabBarView.bindBtnsForPage(2, R.drawable.chats_icon, R.drawable.search_icon, 0);
        mTabBarView.bindBtnsForPage(3, R.drawable.settings_icon, 0, R.drawable.edit_icon);
        mTabBarView.initializePage(0);

    }

    private TabBarView.OnTabBarClickListener initTabBarClickListener(){
        return new TabBarView.OnTabBarClickListener() {
            @Override
            public void onMainBtnsClick(int position, int[] clickLocation) {
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Log.d("position",position + "");
                switch (position) {
                    case 0:
                        if (firstPageFragment == null)
                        {
                            firstPageFragment = new FirstPageFragment();
                        }
                        // 使用当前Fragment的布局替代content的控件
                        transaction.replace(R.id.content, firstPageFragment);
                        break;
                    case 1:
                        if (noticeFragment == null)
                        {
                            noticeFragment = new NoticeFragment();
                        }
                        transaction.replace(R.id.content, noticeFragment);
                        break;
                    case 3:
                        if (clasFragment == null)
                        {
                            clasFragment = new ClasFragment();
                        }
                        transaction.replace(R.id.content,clasFragment);
                        break;
                }
                transaction.commit();

            }

            @Override
            public void onMainBtnsClick(int position) {

            }

            @Override
            public void onLeftBtnClick(int page) {
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (page) {
                    case 0:
                        firstPageFragment = new FirstPageFragment();
                        // 使用当前Fragment的布局替代content的控件
                        transaction.replace(R.id.content, firstPageFragment);
                        break;
                }
                transaction.commit();

            }

            @Override
            public void onRightBtnClick(int page) {
                switch (page) {
                    case 0:
                        Intent i = new Intent(MainActivity.this,KeyWordActivity.class);
                        startActivity(i);
                }
            }
        };
    }

    @Override
    public void onFirstCallBack(MyCard mCard) {
        String url = mCard.getmHref();
        Intent i = new Intent(MainActivity.this, SurfActivity.class);
        i.putExtra("url",url);
        startActivity(i);
    }

    @Override
    public void onClasCallBack(MyClas clas) {
        String url = clas.getUrl();
        Intent i = new Intent(MainActivity.this, SurfActivity.class);
        i.putExtra("url", url);
        startActivity(i);
    }
}
