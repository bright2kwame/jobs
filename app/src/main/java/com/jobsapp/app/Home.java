package com.jobsapp.app;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jobsapp.app.fragment.FragmentHome;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView textView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        context = this;
        Toolbar toolbar = findViewById(R.id.toolbar);
        textView = findViewById(R.id.textViewTitle);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.getMenu().performIdentifierAction(R.id.menu_vacancies, 0);
        navigationView.setCheckedItem(R.id.menu_vacancies);

        navigationView.setItemIconTintList(null);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        if (menuItem.isChecked())
            menuItem.setChecked(false);
        else
            menuItem.setChecked(true);

        //Closing drawer on item click
        drawerLayout.closeDrawers();

        String name = getString(R.string.app_name);
        Fragment fragment = null;
        Bundle args = new Bundle();

        switch (menuItem.getItemId()) {
            case R.id.menu_vacancies:
                fragment = new FragmentHome();
                break;
        }

        if (fragment == null) {
            return false;
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragment.setArguments(args);
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
        textView.setText(name);
        return true;
    }
}
