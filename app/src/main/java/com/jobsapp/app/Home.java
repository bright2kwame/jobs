package com.jobsapp.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;

import com.jobsapp.app.fragment.FragmentList;
import com.jobsapp.app.fragment.FragmentMap;
import com.jobsapp.app.helper.AppUtils;
import com.jobsapp.app.helper.Base;

public class Home extends Base {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Context context;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;
        tabLayout = findViewById(R.id.tabLayout);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_list)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_map)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = findViewById(R.id.viewPager);
        final HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(@Nullable TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppUtils.navigateUpKeep(Home.this, PostJob.class, null);
            }
        });

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_home;
    }

    @Override
    protected void setUpWidget() {

    }

    @Override
    protected String setTitle() {
        return getString(R.string.app_name);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public class HomePagerAdapter extends FragmentPagerAdapter {
        int mNumOfTabs;

        public HomePagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            String title = getString(R.string.app_name);
            switch (position) {
                case 0:
                    title = getString(R.string.tab_list);
                    break;
                case 1:
                    title = getString(R.string.tab_map);
                    break;
                default:
                    break;
            }

            return title;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new FragmentList();
                    break;
                case 1:
                    fragment = new FragmentMap();
                    break;
                default:
                    break;
            }
            return fragment;

        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }

    }
}
