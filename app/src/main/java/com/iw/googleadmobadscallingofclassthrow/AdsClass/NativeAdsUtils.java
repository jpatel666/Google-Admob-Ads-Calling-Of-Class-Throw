package com.iw.googleadmobadscallingofclassthrow.AdsClass;

import android.app.Activity;
import android.view.View;

import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.nativead.NativeAd;
import com.iw.googleadmobadscallingofclassthrow.R;
import com.iw.googleadmobadscallingofclassthrow.ShowNativeAdsActivity;

public class NativeAdsUtils {

    Activity activity;
    TemplateView templateView;

    public NativeAdsUtils(Activity activity, TemplateView templateView) {
        this.activity = activity;
        this.templateView = templateView;
    }

    public void loadNative() {
        AdLoader adLoader = new AdLoader.Builder(activity,activity.getString(R.string.native_id))
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().build();
                        TemplateView template = templateView.findViewById(R.id.my_template);
                        template.setStyles(styles);
                        template.setNativeAd(nativeAd);
                    }
                })
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }


}
