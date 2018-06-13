package com.ayusheg.launcherlock;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class mainScreenActivity extends AppCompatActivity {

    // Call `launchBackgroundRun()` in the activity
    // to startup the service
    public void launchBackgroundRun() {
        // Construct our Intent specifying the Service
        Intent i = new Intent(this, backgroundRun.class);
        // Add extras to the bundle
        i.putExtra("foo", "bar");
        // Start the service
        startService(i);

    }

    public void onCreate(Bundle savedInstanceState) {
        if(getResources().getBoolean(R.bool.portrait_only))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        AdView mAdview = (AdView) findViewById(R.id.adView);
        AdView mAdview2 = (AdView) findViewById(R.id.adView2);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);
        mAdview2.loadAd(adRequest);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinatorLayout);

        checkBox = (CheckBox) findViewById(R.id.checkBox);

        checkBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final Snackbar snackbar = Snackbar.make(coordinatorLayout, "Lock Adjusted", Snackbar.LENGTH_LONG);
                snackbar.setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
                }
            });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ContactMe:
                startActivity(new Intent(this, contactMeActivity.class));
                return true;
            case R.id.Credits:
                startActivity(new Intent(this, creditsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private CoordinatorLayout coordinatorLayout;
    protected Button checkBox;
}