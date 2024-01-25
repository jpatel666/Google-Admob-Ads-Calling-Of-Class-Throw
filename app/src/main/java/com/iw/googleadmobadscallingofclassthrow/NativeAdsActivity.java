package com.iw.googleadmobadscallingofclassthrow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.iw.googleadmobadscallingofclassthrow.AdsClass.NativeAdsUtils;

public class NativeAdsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_ads);

        NativeAdsUtils nativeAdsUtils = new NativeAdsUtils(NativeAdsActivity.this,findViewById(R.id.my_template));
        nativeAdsUtils.loadNative();
    }
}