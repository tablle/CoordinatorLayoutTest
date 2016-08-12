package com.tablle.newtest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class CoolapsingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coolapsing);

        CollapsingToolbarLayout collapsing_toolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitle("详情页面");

        collapsing_toolbar.setCollapsedTitleTextColor(Color.WHITE);

        collapsing_toolbar.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);//伸展
        collapsing_toolbar.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);//收缩
        //collapsing_toolbar.setExpandedTitleTextAppearance(R.style.ExpandedAppBarPlus1);
        //collapsing_toolbar.setCollapsedTitleTextAppearance(R.style.CollapsedAppBarPlus1);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
