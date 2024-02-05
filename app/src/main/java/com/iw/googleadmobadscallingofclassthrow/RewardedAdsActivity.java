package com.iw.googleadmobadscallingofclassthrow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.iw.googleadmobadscallingofclassthrow.AdsClass.RewardedAdsUtils;

public class RewardedAdsActivity extends AppCompatActivity {

    Button btnRewardedAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded_ads);

        btnRewardedAds = findViewById(R.id.btnRewardedads);

        btnRewardedAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RewardedAdsUtils rewardedAdsUtils = new RewardedAdsUtils(RewardedAdsActivity.this);
                rewardedAdsUtils.loadReward();

            }
        });
    }
}