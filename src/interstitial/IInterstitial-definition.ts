import { PluginListenerHandle } from "@capacitor/core";
import { AdError, AdLoadInfo, AdOptions, AdRewardItem } from "./../shared";
import { InterstitialAdPluginEvents } from "./interstitial-ad-plugin-events.enum";

export interface InterstitialDefinitions {
    /**
      * Prepare a reward video ad
      *
      * @group RewardVideo
      * @param options AdOptions
      * @since 1.1.2
      */
    //prepareInterstitial(options: AdOptions): Promise<AdLoadInfo>;

    /**
     * Show a reward video ad
     *
     * @group RewardVideo
     * @since 1.1.2
     */
    showInterstitial(options: AdOptions): Promise<AdRewardItem>;

    addListener(
        eventName: InterstitialAdPluginEvents.FailedToLoad,
        listenerFunc: (error: AdError) => void,
    ): PluginListenerHandle;

    addListener(
        eventName: InterstitialAdPluginEvents.Loaded,
        listenerFunc: (info: AdLoadInfo) => void,
    ): PluginListenerHandle;

    addListener(
        eventName: InterstitialAdPluginEvents.Showed,
        listenerFunc: (reward: AdRewardItem) => void,
    ): PluginListenerHandle;

    addListener(
        eventName: InterstitialAdPluginEvents.Dismissed,
        listenerFunc: () => void,
    ): PluginListenerHandle;


    addListener(
        eventName: InterstitialAdPluginEvents.FailedToShow,
        listenerFunc: (error: AdError) => void,
    ): PluginListenerHandle;

}