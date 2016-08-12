package com.tablle.newtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.tablle.newtest.adapter.ViewPagerAdapter;
import com.tablle.newtest.fragment.AttentionFragment;
import com.tablle.newtest.fragment.FindFragment;
import com.tablle.newtest.fragment.HomeFragment;
import com.tablle.newtest.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> list_fragment;                         //fragment列表
    private List<String> list_Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);

        HomeFragment homeFragment = new HomeFragment();
        AttentionFragment attentionFragment = new AttentionFragment();
        FindFragment findFragment = new FindFragment();
        MineFragment mineFragment = new MineFragment();

        list_fragment = new ArrayList<>();
        list_fragment.add(homeFragment);
        list_fragment.add(attentionFragment);
        list_fragment.add(findFragment);
        list_fragment.add(mineFragment);

        list_Title = new ArrayList<>();
        list_Title.add("首页");
        list_Title.add("关注");
        list_Title.add("发现");
        list_Title.add("我的");

        //设置TabLayout的模式
        //tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tabLayout.addTab(tabLayout.newTab().setText(list_Title.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(list_Title.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(list_Title.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(list_Title.get(3)));

        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(),list_fragment,list_Title);
        viewPager.setAdapter(vpAdapter);
        tabLayout.setupWithViewPager(viewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "快点联系我吧，亲~", Snackbar.LENGTH_LONG)
                        .setAction("ok~", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"Hello,qin~",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
