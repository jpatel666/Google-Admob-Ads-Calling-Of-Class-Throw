package com.iw.googleadmobadscallingofclassthrow.AdsClass;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.iw.googleadmobadscallingofclassthrow.R;

public class RewardedAdsUtils {

    Activity activity;
    private RewardedAd rewardedAd;


    public RewardedAdsUtils(Activity activity) {
        this.activity = activity;
    }

    public void loadReward() {

        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(activity, activity.getResources().getString(R.string.rewarded_id),
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        rewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd ad) {
                        rewardedAd = ad;

                        rewardedAd.show(activity, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                int rewardAmount = rewardItem.getAmount();
                                String rewardType = rewardItem.getType();
                            }
                        });

                        rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {

                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {

                                rewardedAd = null;
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {

                                rewardedAd = null;
                            }

                            @Override
                            public void onAdImpression() {

                            }

                            @Override
                            public void onAdShowedFullScreenContent() {

                            }
                        });
                    }
                });


    }


}
