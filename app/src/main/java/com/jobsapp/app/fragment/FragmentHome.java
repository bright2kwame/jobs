package com.jobsapp.app.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jobsapp.app.AppUtils;
import com.jobsapp.app.PostJob;
import com.jobsapp.app.R;


/**
 * Created by Monarchy on 25/04/16.
 */
public class FragmentHome extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Context context;
    private FloatingActionButton floatingActionButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        context = getActivity();
        tabLayout = view.findViewById(R.id.tabLayout);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_list)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_map)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = view.findViewById(R.id.viewPager);
        final HomePagerAdapter adapter = new HomePagerAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
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
                AppUtils.navigateUpKeep(getActivity(), PostJob.class, null);
            }
        });

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
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
