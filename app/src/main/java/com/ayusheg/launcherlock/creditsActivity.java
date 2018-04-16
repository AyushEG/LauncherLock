package com.ayusheg.launcherlock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class creditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        AdView mAdview3 = (AdView) findViewById(R.id.adView3);
        AdView mAdview4 = (AdView) findViewById(R.id.adView4);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview3.loadAd(adRequest);
        mAdview4.loadAd(adRequest);
    }
}