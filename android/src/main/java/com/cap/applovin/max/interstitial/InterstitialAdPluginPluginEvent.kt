//package com.readysteadygo.app.cap.mopub.ad.interstitial
package com.cap.applovin.max.interstitial;

import com.cap.applovin.max.models.LoadPluginEventNames


object InterstitialAdPluginPluginEvent: LoadPluginEventNames {
    const val Loaded = "interstitialAdLoaded"
    const val FailedToLoad = "interstitialAdFailedToLoad"
    override val Showed = "interstitialAdShowed"
    override val FailedToShow = "interstitialAdFailedToShow"
    override val Dismissed = "interstitialAdDismissed"
}