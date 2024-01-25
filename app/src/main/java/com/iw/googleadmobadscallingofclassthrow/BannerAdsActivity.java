package com.iw.googleadmobadscallingofclassthrow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.iw.googleadmobadscallingofclassthrow.AdsClass.BannerAdsUtils;

public class BannerAdsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_ads);

        BannerAdsUtils bannerAdsUtils = new BannerAdsUtils(BannerAdsActivity.this,findViewById(R.id.linearAdaptive));
        bannerAdsUtils.bannerAdaptive();

    }
}