package com.shaheershukur.admobtutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this);
    }

    public void openAdActivity(View view) {
        switch (view.getId()) {
            case R.id.banner_ad_button:
                Intent intentBanner = new Intent(this, BannerActivity.class);
                startActivity(intentBanner);
                break;
            case R.id.interstitial_ad_button:
                Intent intentInterstitial = new Intent(this, InterstitialActivity.class);
                startActivity(intentInterstitial);
                break;
            case R.id.native_ad_button:
                Intent intentNative = new Intent(this, NativeActivity.class);
                startActivity(intentNative);
                break;
            case R.id.rewarded_ad_button:
                Intent intentRewarded = new Intent(this, RewardedActivity.class);
                startActivity(intentRewarded);
                break;
        }
    }
}
