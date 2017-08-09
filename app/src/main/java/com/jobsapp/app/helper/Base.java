package com.jobsapp.app.helper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;

import com.jobsapp.app.R;

/**
 * Created by Monarchy on 1/12/2016.
 */
public abstract class Base extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        configureToolbar();
        setUpWidget();
    }


    protected abstract int getLayoutResourceId();

    protected abstract void setUpWidget();

    protected abstract String setTitle();

    private void configureToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView textView = findViewById(R.id.textViewTitle);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("");
        }
        if (textView != null) {
            textView.setText(setTitle());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onKeyUp(int keycode, KeyEvent e) {
        switch (keycode) {
            case KeyEvent.KEYCODE_MENU:
                if (getSupportActionBar() != null) {
                    getSupportActionBar().openOptionsMenu();
                    return true;
                }
        }

        return super.onKeyUp(keycode, e);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public TextView getActionBarTitle() {
        return (TextView) findViewById(R.id.textViewTitle);
    }

}
