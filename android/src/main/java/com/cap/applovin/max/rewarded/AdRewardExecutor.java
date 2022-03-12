package com.cap.applovin.max.rewarded;


import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.util.Supplier;

import com.applovin.sdk.AppLovinSdk;
import com.cap.applovin.max.models.Executor;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.google.android.gms.common.util.BiConsumer;


import java.util.Set;

public class AdRewardExecutor extends Executor {
    private static String  AdUnitId= "";

    private final String TAG = AdRewardExecutor.class.getSimpleName();
    //private MoPubRewardedAdListener rewardedAdListener;
    public AdRewardExecutor(
        Supplier<Context> contextSupplier,
        Supplier<Activity> activitySupplier,
        BiConsumer<String, JSObject> notifyListenersFunction,
        String pluginLogTag
    ) {
        super(contextSupplier, activitySupplier, notifyListenersFunction, pluginLogTag, "AdRewardExecutor");
    }
/*
    @PluginMethod
    public void prepareRewardVideoAd(final PluginCall call, BiConsumer<String, JSObject> notifyListenersFunction) {
        //final AdOptions adOptions = AdOptions.getFactory().createRewardVideoOptions(call);

        activitySupplier
            .get()
            .runOnUiThread(
                () -> {
                    try {
                        //final AdRequest adRequest = RequestHelper.createRequest(adOptions);
                        final String adUnitId =call.getString("adId"); //AdViewIdHelper.getFinalAdId(adOptions, adRequest, logTag, contextSupplier.get());
                        AdUnitId = adUnitId;
*//*
                        if(!AudienceNetworkAds.isInitialized(activitySupplier.get()))
                            AudienceNetworkAds.initialize(activitySupplier.get());

                        ////////============== Ad iron source ad config
                        Map<String, String> ironSourceSettings = new HashMap<>();
                        ironSourceSettings.put("applicationKey","101676ad9");
                        String adcolonyAppId = "appaa8c1d145895406db1";
                        String[] allZoneIds = new String[]{"vzca8158d3744449a6a8"};

                        AdColony.configure(activitySupplier.get(), adcolonyAppId, allZoneIds);
                        ////////============== Ad colony ad config
                        Map<String, String> adColonyConfigs = new HashMap<>();
                        adColonyConfigs.put("appId", adcolonyAppId);

                        adColonyConfigs.put("allZoneIds", Arrays.toString(allZoneIds));
                        SdkConfiguration.Builder configBuilder = new SdkConfiguration.Builder(AdUnitId);
                        configBuilder.withMediatedNetworkConfiguration(IronSourceAdapterConfiguration.class.getName(),ironSourceSettings);
                        configBuilder.withMediatedNetworkConfiguration(AdColonyAdapterConfiguration.class.getName(), adColonyConfigs);
                        MobileAds.initialize(contextSupplier.get());

                        MoPub.onCreate(activitySupplier.get());
                        MoPub.initializeSdk(contextSupplier.get(), configBuilder.build(), initSdkListener());*//*
                        //MoPub.initializeSdk();

                        rewardedAdListener = new MoPubRewardedAdListener() {
                            @Override
                            public void onRewardedAdLoadSuccess(String adUnitId) {
                                // Called when the ad for the given adUnitId has loaded. At this point you should be able to call MoPubRewardedAds.showRewardedAd() to show the ad.
                                MoPubRewardedAds.showRewardedAd(adUnitId);
                            }
                            @Override
                            public void onRewardedAdLoadFailure(String adUnitId, MoPubErrorCode errorCode) {

                                // Called when the ad fails to load for the given adUnitId. The provided error code will provide more insight into the reason for the failure to load.
                                JSObject jsObject = new JSObject();
                                jsObject.put("ErrorCode", errorCode.getIntCode())
                                        .put("ErrorMessage", errorCode.name());
                                notifyListenersFunction.accept("onRewardedVideoAdFailedToShow", jsObject);
                                call.resolve(jsObject);
                            }

                            @Override
                            public void onRewardedAdStarted(String adUnitId) {
                                // Called when a rewarded ad starts playing.
                            }

                            @Override
                            public void onRewardedAdShowError(String adUnitId, MoPubErrorCode errorCode) {
                                //  Called when there is an error while attempting to show the ad.

                                JSObject jsObject = new JSObject();
                                jsObject.put("ErrorCode", errorCode.getIntCode())
                                        .put("ErrorMessage", errorCode.name());
                                notifyListenersFunction.accept("onRewardedVideoAdFailedToShow", jsObject);

                                //Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());
                                call.resolve(jsObject);

                            }

                            @Override
                            public void onRewardedAdClicked(@NonNull String adUnitId) {
                                //  Called when a rewarded ad is clicked.
                            }

                            @Override
                            public void onRewardedAdClosed(String adUnitId) {
                                // Called when a rewarded ad is closed. At this point your application should resume.
                                RewardedAdCallbackAndListeners.INSTANCE.getOnUserEarnedRewardListener(call, notifyListenersFunction);
                            }

                            @Override
                            public void onRewardedAdCompleted(Set<String> adUnitIds, MoPubReward reward) {
                                // Called when a rewarded ad is completed and the user should be rewarded.
                                // You can query the reward object with boolean isSuccessful(), String getLabel(), and int getAmount().
                            }
                        };
                        MoPubRewardedAds.setRewardedAdListener(rewardedAdListener);






                         JSObject jsObject = new JSObject();
                         jsObject.put("Ad Prepared","Add is ready to show now.");
                        call.resolve(jsObject);
                    } catch (Exception ex) {
                        call.reject(ex.getLocalizedMessage(), ex);
                    }
                }
            );
    }*/


    /*private AppLovinSdk.SdkInitializationListener initSdkListener() {
        return new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onInitializationFinished() {
                // SDK initialization complete. You may now request ads.

                MoPubRewardedAds.loadRewardedAd(AdUnitId);


            }
        };
    }*/

   /* @PluginMethod
    public void showRewardVideoAd(final PluginCall call, BiConsumer<String, JSObject> notifyListenersFunction) {
       *//* if (mRewardedAd == null) {
            String errorMessage = "No Reward Video Ad can be show. It was not prepared or maybe it failed to be prepared.";
            call.reject(errorMessage);
            AdMobPluginError errorObject = new AdMobPluginError(-1, errorMessage);
            notifyListenersFunction.accept(RewardAdPluginEvents.FailedToLoad, errorObject);
            return;
        }*//*

        try {
            activitySupplier
                .get()
                .runOnUiThread(
                    () -> {



                        *//*mRewardedAd.show(
                            activitySupplier.get(),
                            RewardedAdCallbackAndListeners.INSTANCE.getOnUserEarnedRewardListener(call, notifyListenersFunction)
                        );*//*
                        JSObject jsObject = new JSObject();
                        jsObject.put("Ad showed","Add is showed.");
                        call.resolve(jsObject);
                    }
                );
        } catch (Exception ex) {
            call.reject(ex.getLocalizedMessage(), ex);
        }
    }*/
}
