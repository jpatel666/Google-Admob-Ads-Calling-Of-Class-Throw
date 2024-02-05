package com.iw.googleadmobadscallingofclassthrow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.iw.googleadmobadscallingofclassthrow.AdsClass.InterAdsUtils;

public class InterAdsActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_ads);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InterAdsActivity.this, BannerAdsActivity.class);
                InterAdsUtils interAdsUtils = new InterAdsUtils(InterAdsActivity.this);
                interAdsUtils.loadInter(intent, true);
                //putExtra,Data,...etc...[Code Here]
                //startActivity(intent);...[No]...[InterAdsUtils Class...Code Here]
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InterAdsActivity.this, BannerAdsActivity.class);
                InterAdsUtils interAdsUtils = new InterAdsUtils(InterAdsActivity.this);
                interAdsUtils.loadInter(intent, true);
                //putExtra,Data,...etc...[Code Here]
                //startActivity(intent);...[No]...[InterAdsUtils Class...Code Here]
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InterAdsActivity.this, BannerAdsActivity.class);
                InterAdsUtils interAdsUtils = new InterAdsUtils(InterAdsActivity.this);
                interAdsUtils.loadInter(intent, true);
                //putExtra,Data,...etc...[Code Here]
                //startActivity(intent);...[No]...[InterAdsUtils Class...Code Here]
            }
        });

    }
}