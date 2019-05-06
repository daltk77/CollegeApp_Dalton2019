package com.dalton.collegeapp_dalton2019;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.dalton.collegeapp_dalton2019.R;

public class ApplicantActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //    Create null fragment + Variable instantiation for API_KEY, APP_ID, constant EMAIL_PREF      //

    Fragment contentFragment = null;
    String APP_ID;
    String API_KEY;
    public static String EMAIL_PREF;


    //  On app load, Assign API KEY and APP ID and link with backendless. Then set navigation view and load activity_applicant.xml //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        APP_ID = getString(R.string.APP_ID);
        API_KEY = getString(R.string.API_KEY);
        Backendless.initApp(this,APP_ID, API_KEY);

        /*
        //     Portion of code to register a new user on backendless - Unused       //

        BackendlessUser user = new BackendlessUser();
        user.setEmail("lloydminn@gmail.com");
        user.setPassword("password");
        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                Log.i("user", response.getEmail() + " successfully registered");
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.e("Backendless Error", fault.getMessage());
            }
        });
        */

        setContentView(R.layout.activity_applicant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

//     Opens app drawer on back button press   //
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //      Inflate the menu; this adds items to the action bar if it is present.       //
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //        Handle action bar item clicks here. The action bar will    //
    //        automatically handle clicks on the Home/Up button          //
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //         Handle navigation view item clicks here. Opens new fragment based on which item selected     //
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.family_number) {
            contentFragment = new FamilyListFragment();
        } else if (id == R.id.profile) {
            contentFragment = new ProfileFragment();
        }
        if (contentFragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, contentFragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
