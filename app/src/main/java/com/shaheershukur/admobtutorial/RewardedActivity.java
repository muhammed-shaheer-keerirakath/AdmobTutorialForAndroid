package com.shaheershukur.admobtutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class RewardedActivity extends AppCompatActivity {

    RewardedAd rewardedAd;
    Button videoButton;
    TextView adTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded);

        videoButton = findViewById(R.id.ad_video_button);
        adTextView = findViewById(R.id.ad_text);

        rewardedAd = new RewardedAd(this, "ca-app-pub-3940256099942544/5224354917");

        rewardedAd.loadAd(new AdRequest.Builder().build(), new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                super.onRewardedAdLoaded();
                videoButton.setVisibility(View.VISIBLE);
            }
        });

        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayAd();
            }
        });
    }

    public void displayAd() {
        rewardedAd.show(this, new RewardedAdCallback() {
            @Override
            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                videoButton.setVisibility(View.INVISIBLE);

                adTextView.setText("1 available");
            }
        });
    }
}
