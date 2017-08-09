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
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jobsapp.app.fragment.FragmentList;
import com.jobsapp.app.fragment.FragmentMap;
import com.jobsapp.app.helper.AppUtils;
import com.jobsapp.app.helper.Base;

import java.util.ArrayList;
import java.util.List;

public class Home extends Base {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Context context;
    private FloatingActionButton floatingActionButton;
    private ImageView imageViewProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;

        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_list)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_map)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
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


        imageViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppUtils.navigateUpKeep(Home.this, Profile.class, null);
            }
        });

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_home;
    }

    @Override
    protected void setUpWidget() {
        imageViewProfile = findViewById(R.id.imageViewProfile);
        tabLayout = findViewById(R.id.tabLayout);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        viewPager = findViewById(R.id.viewPager);
    }

    @Override
    protected String setTitle() {
        return getString(R.string.app_name);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_filter) {
            showFilterMenu();
            return true;
        }
        return super.onOptionsItemSelected(item);
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

    private void showFilterMenu() {
        List<String> list = new ArrayList<>();
        list.add("UI Developer");
        list.add("UX Developer");
        list.add("Front End Developer");
        new MaterialDialog.Builder(context)
                .title("Filter Jobs")
                .items(list)
                .cancelable(true)
                .negativeText("Ok")
                .show();
    }
}
