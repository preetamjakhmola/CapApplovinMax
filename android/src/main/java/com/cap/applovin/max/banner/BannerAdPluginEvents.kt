package com.cap.applovin.max.banner

enum class BannerAdPluginEvents(val webEventName: String) {
    SizeChanged("bannerAdSizeChanged"),
    Closed("bannerAdClosed"),
    FailedToLoad("bannerAdFailedToLoad"),
    Opened("bannerAdOpened"),
    Loaded("bannerAdLoaded"),
    Clicked("bannerAdClicked"),
    AdImpression("bannerAdImpression"),
}