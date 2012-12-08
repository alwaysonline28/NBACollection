package com.nba.collection;


import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;

public class NBACollectionActivity extends TabActivity
{
    
    private TabHost mTabHost;

    
    private TabWidget mTabWidget;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        mTabHost = this.getTabHost();
        mTabHost.setPadding(mTabHost.getPaddingLeft(),
                mTabHost.getPaddingTop(), mTabHost.getPaddingRight(),
                mTabHost.getPaddingBottom() - 5);
        Resources rs = getResources();

        Intent newsintent = new Intent();
        newsintent.setClass(this, News.class);
        TabHost.TabSpec newsspec = mTabHost.newTabSpec("热点");
        newsspec.setIndicator("",
        		rs.getDrawable(R.drawable.news));
        newsspec.setContent(newsintent);
        mTabHost.addTab(newsspec);

        Intent compareintent = new Intent();
        compareintent.setClass(this, Compare.class);
        TabHost.TabSpec comparespec = mTabHost.newTabSpec("评比");
        comparespec.setIndicator("",
        		rs.getDrawable(R.drawable.compare));
        comparespec.setContent(compareintent);
        mTabHost.addTab(comparespec);

        Intent dataintent = new Intent();
        dataintent.setClass(this, Data.class);
        TabHost.TabSpec dataspec = mTabHost.newTabSpec("资料");
        dataspec.setIndicator("",
        		rs.getDrawable(R.drawable.data)  );
        dataspec.setContent(dataintent);
        mTabHost.addTab(dataspec);
        
        Intent pictureintent = new Intent();
        pictureintent.setClass(this, ImageViewActivity.class);
        TabHost.TabSpec picturespec = mTabHost.newTabSpec("图库");
        picturespec.setIndicator("",rs.getDrawable(R.drawable.picture));
//                rs.getDrawable(android.R.drawable.stat_sys_phone_call_on_hold));
        picturespec.setContent(pictureintent);
        mTabHost.addTab(picturespec);

        mTabWidget = mTabHost.getTabWidget();
        for (int i = 0; i < mTabWidget.getChildCount(); i++)
        {
            View view = mTabWidget.getChildAt(i);
            if (mTabHost.getCurrentTab() == i)
            {
                view.setBackgroundDrawable(getResources().getDrawable(
                        R.drawable.number_bg_pressed));
            }
            else
            {
                view.setBackgroundDrawable(getResources().getDrawable(
                        R.drawable.number_bg));
            }
            mTabWidget.getChildAt(i).getLayoutParams().height = 50;
            TextView tv = (TextView) mTabWidget.getChildAt(i).findViewById(
                    android.R.id.title);
            tv.setTextColor(Color.rgb(49, 116, 171));
        }

        mTabHost.setOnTabChangedListener(new OnTabChangeListener()
        {
            public void onTabChanged(String tabId)
            {
                for (int i = 0; i < mTabWidget.getChildCount(); i++)
                {
                    View view = mTabWidget.getChildAt(i);
                    if (mTabHost.getCurrentTab() == i)
                    {
                        view.setBackgroundDrawable(getResources().getDrawable(
                                R.drawable.number_bg_pressed));
                    }
                    else
                    {
                        view.setBackgroundDrawable(getResources().getDrawable(
                                R.drawable.number_bg));
                    }
                }
            }
        });
    }
}
