package com.jobsapp.app;

import android.os.Bundle;

import com.jobsapp.app.helper.Base;

public class PostJob extends Base {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_post_job;
    }

    @Override
    protected void setUpWidget() {

    }

    @Override
    protected String setTitle() {
        return getString(R.string.new_job);
    }
}
