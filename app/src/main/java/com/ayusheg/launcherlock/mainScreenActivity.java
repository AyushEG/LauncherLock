package com.ayusheg.launcherlock;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        AdView adview = (AdView) findViewById(R.id.adView);
        AdView adview2 = (AdView) findViewById(R.id.adView2);

        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
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

    public class MainActivity extends AppCompatActivity {
        View.OnClickListener mOnClickListener;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_screen);

            final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                    .coordinatorLayout);
            final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Snackbar snackbar = Snackbar
                                .make(coordinatorLayout, "LauncherLock Active", Snackbar.LENGTH_LONG)
                                .setAction("Undo", mOnClickListener);
                        snackbar.setActionTextColor(Color.GREEN);
                        View snackbarView = snackbar.getView();
                        snackbarView.setBackgroundColor(Color.DKGRAY);
                        TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextColor(Color.YELLOW);
                        snackbar.show();
                    }
                }
            });

            mOnClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkBox.setChecked(false);
                }
            };
        }
    }
}