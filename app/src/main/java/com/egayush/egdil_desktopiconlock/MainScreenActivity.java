package com.egayush.egdil_desktopiconlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;

import static com.egayush.egdil_desktopiconlock.R.id.checkBox;

public class MainScreenActivity extends AppCompatActivity {

    // Call `launchBackgroundRun()` in the activity
    // to startup the service
    public void launchBackgroundRun() {
        // Construct our Intent specifying the Service
        Intent i = new Intent(this, BackgroundRun.class);
        // Add extras to the bundle
        i.putExtra("foo", "bar");
        // Start the service
        startService(i);

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
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
                startActivity(new Intent(this, ContactMeActivity.class));
                return true;
            case R.id.Credits:
                startActivity(new Intent(this, CreditsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}