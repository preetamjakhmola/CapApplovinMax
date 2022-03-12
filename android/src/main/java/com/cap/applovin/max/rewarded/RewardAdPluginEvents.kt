package com.cap.applovin.max.rewarded;


import com.cap.applovin.max.models.LoadPluginEventNames



object RewardAdPluginEvents: LoadPluginEventNames {
    const val Loaded = "onRewardedVideoAdLoaded"
    const val FailedToLoad = "onRewardedVideoAdFailedToLoad"
    const val Rewarded = "onRewardedVideoAdReward"
    override val Showed = "onRewardedVideoAdShowed"
    override val FailedToShow = "onRewardedVideoAdFailedToShow"
    override val Dismissed = "onRewardedVideoAdDismissed"
}