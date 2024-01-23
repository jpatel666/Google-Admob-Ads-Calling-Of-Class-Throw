package com.iw.googleadmobadscallingofclassthrow.AdsClass;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
import android.view.WindowMetrics;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.iw.googleadmobadscallingofclassthrow.R;

public class BannerAdsUtils {
    AdView adView;
    private boolean initialLayoutComplete = false;
    Activity showBannerAdsActivity;
    LinearLayout adContainerView;

    public BannerAdsUtils(Activity showBannerAdsActivity, LinearLayout adContainerView) {

        this.showBannerAdsActivity = showBannerAdsActivity;
        this.adContainerView = adContainerView;
    }

    public void bannerAdaptive() {
        adView = new AdView(showBannerAdsActivity);
        adContainerView.addView(adView);

        adContainerView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        if (!initialLayoutComplete) {
                            initialLayoutComplete = true;
                            loadBanner();
                        }
                    }
                });
    }

    private void loadBanner() {
        adView.setAdUnitId(showBannerAdsActivity.getString(R.string.banner_id));

        AdSize adSize = getAdSize();
        adView.setAdSize(adSize);


        AdRequest adRequest =
                new AdRequest.Builder().build();


        adView.loadAd(adRequest);
    }

    @SuppressLint({"NewApi", "LocalSuppress"})
    private AdSize getAdSize() {
        WindowMetrics windowMetrics = showBannerAdsActivity.getWindowManager().getCurrentWindowMetrics();
        Rect bounds = windowMetrics.getBounds();

        float adWidthPixels = adContainerView.getWidth();

        if (adWidthPixels == 0f) {
            adWidthPixels = bounds.width();
        }

        float density = showBannerAdsActivity.getResources().getDisplayMetrics().density;
        int adWidth = (int) (adWidthPixels / density);

        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(showBannerAdsActivity, adWidth);
    }

}
