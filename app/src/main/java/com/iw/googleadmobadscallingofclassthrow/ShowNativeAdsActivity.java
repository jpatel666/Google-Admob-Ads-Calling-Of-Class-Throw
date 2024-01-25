package com.iw.googleadmobadscallingofclassthrow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.iw.googleadmobadscallingofclassthrow.AdsClass.NativeAdsUtils;

public class ShowNativeAdsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_native_ads);

        NativeAdsUtils nativeAdsUtils = new NativeAdsUtils(ShowNativeAdsActivity.this,findViewById(R.id.my_template));
        nativeAdsUtils.loadNative();
    }
}