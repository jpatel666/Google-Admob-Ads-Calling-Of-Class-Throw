package com.iw.googleadmobadscallingofclassthrow.AdsClass;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.iw.googleadmobadscallingofclassthrow.R;
import com.kaopiz.kprogresshud.KProgressHUD;

public class InterAdsUtils {

    Activity activity;
    private InterstitialAd mInterstitialAd;

    public InterAdsUtils(Activity activity) {

        this.activity = activity;

    }

    public void loadInter(Intent intent, boolean isFinish) {

        KProgressHUD hud = KProgressHUD.create(activity)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(activity, activity.getResources().getString(R.string.inter_id), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                        hud.dismiss();
                        mInterstitialAd.show(activity);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {

                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                mInterstitialAd = null;
                                activity.startActivity(intent);
                                if (isFinish) {
                                    activity.finish();
                                }


                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                mInterstitialAd = null;
                                activity.startActivity(intent);
                                if (isFinish) {
                                    activity.finish();
                                }
                            }

                            @Override
                            public void onAdImpression() {

                            }

                            @Override
                            public void onAdShowedFullScreenContent() {

                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                        hud.dismiss();
                        activity.startActivity(intent);
                        if (isFinish) {
                            activity.finish();
                        }
                    }
                });
    }
}
