package com.cap.applovin.max.interstitial;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

import androidx.core.util.Supplier;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.cap.applovin.max.models.Executor;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.google.android.gms.common.util.BiConsumer;
import com.applovin.mediation.MaxAdListener;

import java.util.concurrent.TimeUnit;

public class AdInterstitialExecutor extends Executor
        implements MaxAdListener {

    private MaxInterstitialAd interstitialAd;
    private int retryAttempt;
    InterstitialAdCallbackAndListeners adCallbackAndListeners;
    PluginCall _call=null;

    public AdInterstitialExecutor(
            Supplier<Context> contextSupplier,
            Supplier<Activity> activitySupplier,
            BiConsumer<String, JSObject> notifyListenersFunction,
            String pluginLogTag,
            InterstitialAdCallbackAndListeners adCallbackAndListeners
    ) {
        super(contextSupplier, activitySupplier, notifyListenersFunction, pluginLogTag, "AdRewardExecutor");
        this.adCallbackAndListeners = adCallbackAndListeners;
    }

    public void prepareInterstitial(final PluginCall call, BiConsumer<String, JSObject> notifyListenersFunction) {

        try {
            activitySupplier
                    .get()
                    .runOnUiThread(
                            () -> {

                                String adUnitId = call.getString("adId");

                               /* InterstitialDetail idf;
                                idf = new InterstitialDetail();
                                idf.LoadInterAd(call,adUnitId,this.contextSupplier.get(),notifyListenersFunction);
*/
                            }
                    );
        } catch (Exception ex) {
            call.reject(ex.getLocalizedMessage(), ex);
        }
    }

    public void showInterstitial(final PluginCall call, BiConsumer<String, JSObject> notifyListenersFunction) {
        _call= call;
        activitySupplier
                .get()
                .runOnUiThread(
                        () -> {
                            try {
                                String adUnitId = call.getString("adId");
                                if(interstitialAd==null) {
                                    interstitialAd = new MaxInterstitialAd(adUnitId, (Activity) this.activitySupplier.get());//(Activity) activitySupplier.get());
                                    interstitialAd.setListener(this);
                                }
                                        /*new MaxAdListener() {
                                    @Override
                                    public void onAdLoaded(MaxAd ad) {
                                        String ss= "";
                                        if ( interstitialAd.isReady() )
                                        {
                                            interstitialAd.showAd();
                                        }
                                    }

                                    @Override
                                    public void onAdDisplayed(MaxAd ad) {
                                        String ss= "";
                                    }

                                    @Override
                                    public void onAdHidden(MaxAd ad) {

                                        String ss= "";

                                    }

                                    @Override
                                    public void onAdClicked(MaxAd ad) {

                                    }

                                    @Override
                                    public void onAdLoadFailed(String adUnitId, MaxError error) {
                                        String ss= "";
                                    }

                                    @Override
                                    public void onAdDisplayFailed(MaxAd ad, MaxError error) {
                                        String ss= "";
                                    }
                                });*/

                                // Load the first ad
                                interstitialAd.loadAd();

                                /*InterstitialDetail idf;
                                idf = new InterstitialDetail();
                                idf.LoadInterAd(call,adUnitId,this.contextSupplier.get(),notifyListenersFunction);*/

                                JSObject jsObject = new JSObject();
                                jsObject.put("Ad Prepared","Add is ready to show now.");
                                call.resolve(jsObject);
                            } catch (Exception ex) {
                                call.reject(ex.getLocalizedMessage(), ex);
                            }
                        }
                );
    }

    @Override
    public void onAdLoaded(MaxAd ad) {
        // Interstitial ad is ready to be shown. interstitialAd.isReady() will now return 'true'

        if (interstitialAd.isReady())
        {
            interstitialAd.showAd();
        }

        // Reset retry attempt
        retryAttempt = 0;
    }

    @Override
    public void onAdDisplayed(MaxAd ad) {

    }

    @Override
    public void onAdHidden(MaxAd ad) {
        // Interstitial ad is hidden. Pre-load the next ad
        InterstitialAdCallbackAndListeners listeners = new InterstitialAdCallbackAndListeners();
        listeners.getOnUserEarnedRewardListener(_call, notifyListenersFunction);
    }

    @Override
    public void onAdClicked(MaxAd ad) {

    }

    @Override
    public void onAdLoadFailed(String adUnitId, MaxError error) {
        retryAttempt++;
        long delayMillis = TimeUnit.SECONDS.toMillis( (long) Math.pow( 2, Math.min( 6, retryAttempt ) ) );

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                interstitialAd.loadAd();
            }
        }, delayMillis);

        InterstitialAdCallbackAndListeners listeners = new InterstitialAdCallbackAndListeners();
        listeners.failedToShowRewardAdListener(_call, notifyListenersFunction,error);
    }

    @Override
    public void onAdDisplayFailed(MaxAd ad, MaxError error) {
        // Interstitial ad failed to display. AppLovin recommends that you load the next ad.
        interstitialAd.loadAd();
    }
}
