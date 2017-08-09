package com.jobsapp.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jobsapp.app.adapter.BaseAdapter;
import com.jobsapp.app.helper.Base;
import com.jobsapp.app.item.Applicant;
import com.jobsapp.app.item.Job;

import java.util.ArrayList;
import java.util.List;

public class ApplicantList extends Base {
    private Context context;
    private BaseAdapter baseAdapter;
    private List<Object> objectList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;

        recyclerView = findViewById(R.id.recyclerView);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        objectList = new ArrayList<>();
        baseAdapter = new BaseAdapter(this, objectList);
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


        Applicant applicant = new Applicant();
        objectList.add(applicant);
        objectList.add(applicant);


    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_applicant_list;
    }

    @Override
    protected void setUpWidget() {

    }

    @Override
    protected String setTitle() {
        return getString(R.string.applicants);
    }
}
