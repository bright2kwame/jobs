package com.jobsapp.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.jobsapp.app.helper.Base;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends Base {
    Timer timer = new Timer();
    private int DELAY = 2000;
    private Intent intent;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = new Intent();
        context = this;

        timer.schedule(new TimerTask() {
            public void run() {
                intent.setClass(context, Home.class);
                startActivity(intent);
            }
        }, DELAY);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void setUpWidget() {

    }

    @Override
    protected String setTitle() {
        return getString(R.string.app_name);
    }
}
