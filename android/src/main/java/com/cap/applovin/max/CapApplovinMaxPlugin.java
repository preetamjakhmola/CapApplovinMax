package com.cap.applovin.max;

import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.sdk.AppLovinSdk;
import com.cap.applovin.max.interstitial.AdInterstitialExecutor;
import com.cap.applovin.max.interstitial.InterstitialAdCallbackAndListeners;
import com.facebook.ads.AudienceNetworkAds;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

@CapacitorPlugin(name = "CapApplovinMax")
public class CapApplovinMaxPlugin extends Plugin {

    private final String TAG = CapApplovinMaxPlugin.class.getSimpleName();
    public static final JSArray EMPTY_TESTING_DEVICES = new JSArray();
   /* private final BannerExecutor bannerExecutor = new BannerExecutor(
            this::getContext,
            this::getActivity,
            this::notifyListeners,
            getLogTag()
    );
    private final AdRewardExecutor adRewardExecutor = new AdRewardExecutor(
            this::getContext,
            this::getActivity,
            this::notifyListeners,
            getLogTag()
    );*/
    private final AdInterstitialExecutor adInterstitialExecutor = new AdInterstitialExecutor(
            this::getContext,
            this::getActivity,
            this::notifyListeners,
            getLogTag(),
            new InterstitialAdCallbackAndListeners()
    );

    private MaxInterstitialAd interstitialAd =null;
    private int retryAttempt;

    // Initialize Facebook with appId
    @PluginMethod
    public void initialize(final PluginCall call) {
        //final boolean initializeForTesting = call.getBoolean("initializeForTesting", false);

        try {
            final String adUnitId = call.getString("adId"); //AdViewIdHelper.getFinalAdId(adOptions, adRequest, logTag, contextSupplier.get());

            interstitialAd=new MaxInterstitialAd( adUnitId, getActivity() );
            // Please make sure to set the mediation provider value to "max" to ensure proper functionality
            AppLovinSdk.getInstance(getContext()).setMediationProvider("max");

            if(!AudienceNetworkAds.isInitialized(getActivity()))
            AudienceNetworkAds.initialize(getActivity());



            JSObject jsObject = new JSObject();
            jsObject.put("status",200);
            call.resolve(jsObject);
        } catch (Exception ex) {
            call.reject(ex.getLocalizedMessage(), ex);
        }
    }

    @PluginMethod
    public void showBanner(final PluginCall call) {
        // bannerExecutor.showBanner(call);
    }

    // Hide the banner, remove it from screen, but can show it later
    @PluginMethod
    public void hideBanner(final PluginCall call) {
        // bannerExecutor.hideBanner(call);
    }

    // Resume the banner, show it after hide
    @PluginMethod
    public void resumeBanner(final PluginCall call) {
        // bannerExecutor.resumeBanner(call);
    }

    // Destroy the banner, remove it from screen.
    @PluginMethod
    public void removeBanner(final PluginCall call) {
        // bannerExecutor.removeBanner(call);
    }

    @PluginMethod
    public void prepareInterstitial(final PluginCall call) {
        adInterstitialExecutor.prepareInterstitial(call, this::notifyListeners);
    }

    // Show interstitial Ad
    @PluginMethod
    public void showInterstitial(final PluginCall call) {
        //adInterstitialExecutor.prepareInterstitial(call, this::notifyListeners);
        adInterstitialExecutor.showInterstitial(call, this::notifyListeners);
    }

    @PluginMethod
    public void prepareRewardVideoAd(final PluginCall call) {

        //adRewardExecutor.prepareRewardVideoAd(call, this::notifyListeners);

    }

    @PluginMethod
    public void showRewardVideoAd(final PluginCall call) {
       // adRewardExecutor.showRewardVideoAd(call, this::notifyListeners);
    }

    /**
     * An Array of devices IDs that will be marked as tested devices.
     *
     * @see <a href="https://developers.google.com/admob/android/test-ads#enable_test_devices">Test Devices</a>
     */
    private void setTestingDevicesTo(final PluginCall call, JSArray testingDevices) {
        // TODO: create a function to automatically get the device ID when isTesting is true? https://stackoverflow.com/a/36242494/1255819
        try {
            final RequestConfiguration configuration = new RequestConfiguration.Builder()
                    .setTestDeviceIds(testingDevices.<String>toList())
                    .build();

            MobileAds.setRequestConfiguration(configuration);
        } catch (JSONException error) {
            call.reject(error.toString());
        }
    }
}
