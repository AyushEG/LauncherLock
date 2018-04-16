package com.ayusheg.launcherlock;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class contactMeActivity extends AppCompatActivity {
    private AdView mAdView5;
    private AdView mAdview6;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_me);
        AdView mAdview5 = (AdView) findViewById(R.id.adView5);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview5.loadAd(adRequest);
        AdView mAdview6 = (AdView) findViewById(R.id.adView6);
        mAdview6.loadAd(adRequest);
    }

    public void button3(View view) {
        Intent blogIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://egayush.wixsite.com/egplace"));
        startActivity(blogIntent);
    }

    public void button2(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","egayush@gmail.com", null));
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }
}