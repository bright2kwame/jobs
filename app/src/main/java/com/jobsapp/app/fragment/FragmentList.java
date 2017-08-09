package com.jobsapp.app.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jobsapp.app.R;
import com.jobsapp.app.adapter.BaseAdapter;
import com.jobsapp.app.item.Job;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Monarchy on 25/04/16.
 */
public class FragmentList extends Fragment {
    private Context context;
    private BaseAdapter baseAdapter;
    private List<Object> objectList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        context = getActivity();

        recyclerView = view.findViewById(R.id.recyclerView);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);

        context = getActivity();
        objectList = new ArrayList<>();
        baseAdapter = new BaseAdapter(getActivity(), objectList);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(baseAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (linearLayoutManager.findLastVisibleItemPosition() >= objectList.size() - 3) {

                }

            }
        });

        swipeRefreshLayout.setRefreshing(false);


        Job job = new Job();
        objectList.add(job);
        objectList.add(job);

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


}
