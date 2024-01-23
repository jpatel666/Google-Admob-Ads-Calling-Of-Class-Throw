package com.iw.googleadmobadscallingofclassthrow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.iw.googleadmobadscallingofclassthrow.AdsClass.BannerAdsUtils;

public class ShowBannerAdsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_banner_ads);

        BannerAdsUtils bannerAdsUtils = new BannerAdsUtils(ShowBannerAdsActivity.this,findViewById(R.id.linearAdaptive));
        bannerAdsUtils.bannerAdaptive();

    }
}