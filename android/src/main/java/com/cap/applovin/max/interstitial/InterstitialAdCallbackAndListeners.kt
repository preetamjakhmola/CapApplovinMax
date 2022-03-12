//package com.readysteadygo.app.cap.mopub.ad.interstitial
package com.cap.applovin.max.interstitial;

import com.applovin.mediation.MaxError
import com.cap.applovin.max.interstitial.AdInterstitialExecutor
import com.getcapacitor.JSObject
import com.getcapacitor.PluginCall

import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.common.util.BiConsumer
import com.cap.applovin.max.helpers.FullscreenPluginCallback

import com.cap.applovin.max.rewarded.RewardAdPluginEvents


public class InterstitialAdCallbackAndListeners {


     public fun getOnUserEarnedRewardListener(call: PluginCall, notifyListenersFunction: BiConsumer<String, JSObject>) {
        val response = JSObject()
        response.put("type", "Milestone")
            .put("amount", 1)
        notifyListenersFunction.accept(InterstitialAdPluginPluginEvent.Showed, response)
       // call.resolve(response)
    }

    public fun failedToShowRewardAdListener(call: PluginCall, notifyListenersFunction: BiConsumer<String, JSObject>,errorCode: MaxError) {
        var jsObject = JSObject();
        jsObject.put("ErrorCode", errorCode.code)
            .put("ErrorMessage", errorCode.message);
        notifyListenersFunction.accept(RewardAdPluginEvents.FailedToShow, jsObject)
        //call.reject()
    }

    /*fun getInterstitialAdLoadCallback(call: PluginCall,
                                      notifyListenersFunction: BiConsumer<String, JSObject>,
    ): InterstitialAdLoadCallback {
        return object : InterstitialAdLoadCallback() {
            override fun onAdLoaded(ad: InterstitialAd) {
                ad.fullScreenContentCallback = FullscreenPluginCallback(InterstitialAdPluginPluginEvent, notifyListenersFunction)

                AdInterstitialExecutor.interstitialAd = ad

                val adInfo = JSObject()
                adInfo.put("adUnitId", ad.adUnitId)
                call.resolve(adInfo)

                notifyListenersFunction.accept(InterstitialAdPluginPluginEvent.Loaded, adInfo)
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                val adMobError = AdMobPluginError(adError)

                notifyListenersFunction.accept(InterstitialAdPluginPluginEvent.FailedToLoad, adMobError)
                call.reject(adError.message)
            }
        }
    }*/
}