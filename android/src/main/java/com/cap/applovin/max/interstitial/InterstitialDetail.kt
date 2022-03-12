// Copyright 2018-2021 Twitter, Inc.
// Licensed under the MoPub SDK License Agreement
// https://www.mopub.com/legal/sdk-license-agreement/

//package com.readysteadygo.app.cap.mopub.ad.interstitial
package com.cap.applovin.max.interstitial;

import android.app.Activity
import android.content.Context
import com.getcapacitor.JSObject
import com.getcapacitor.PluginCall
import com.google.android.gms.common.util.BiConsumer
import com.cap.applovin.max.helpers.CallbacksAdapter

public class InterstitialDetail {
   /* private var moPubInterstitial = null
    //private var showButton: Button? = null
    private var callbacksAdapter: CallbacksAdapter? = null
    //private lateinit var viewHolder: Any
    private var adUnitId = "";
    private lateinit var _call: PluginCall;
    private lateinit var _notifyListenersFunction:BiConsumer<String, JSObject>
    private enum class InterstitialCallbacks(private val callbackName: String) {
        LOADED("onAdLoaded"),
        FAILED("onAdFailed"),
        SHOWN("onAdShown"),
        CLICKED("onAdClicked"),
        DISMISSED("onAdDismissed");

        override fun toString(): String {
            return callbackName
        }
    }

    public fun LoadInterAd(call: PluginCall, adUnit: String, contxt: Context,
                           notifyListenersFunction:BiConsumer<String, JSObject>) {
        adUnitId = adUnit;
        _call = call;
        val _context = contxt;
        _notifyListenersFunction= notifyListenersFunction;
        _context?.let { it ->
            // callbacksView.layoutManager = LinearLayoutManager(_context)
            callbacksAdapter = CallbacksAdapter(it).apply {
                generateCallbackList(InterstitialCallbacks::class.java)
            }.also {
                /// callbacksView.adapter = it
            }
        }
        if (moPubInterstitial == null) {
            _context?.let {
                moPubInterstitial = MoPubInterstitial(it as Activity, adUnitId)
            }
            moPubInterstitial?.interstitialAdListener = this@InterstitialDetail
        }
        val keywords = ""
        val userDataKeywords = ""
        moPubInterstitial?.setKeywords(keywords)
        moPubInterstitial?.setUserDataKeywords(userDataKeywords)
        callbacksAdapter?.generateCallbackList(InterstitialCallbacks::class.java)
        //    viewHolder.shareButton?.isEnabled = false
        moPubInterstitial?.load()

    }

   fun onDestroyView() {
        //super.onDestroyView()
        moPubInterstitial?.destroy()
        moPubInterstitial = null

    }

    // InterstitialAdListener implementation
    override fun onInterstitialLoaded(interstitial: MoPubInterstitial) {
        //showButton?.isEnabled = true
        callbacksAdapter?.notifyCallbackCalled(InterstitialCallbacks.LOADED.toString())
        //Utils.logToast(activity, "Interstitial loaded.")

        if (moPubInterstitial == null || moPubInterstitial?.getAdUnitId().isNullOrEmpty()) {
            // Utils.logToast(activity, "Ad unit is not initialized")
            return
        }

        moPubInterstitial?.show()
    }

    override fun onInterstitialFailed(interstitial: MoPubInterstitial, errorCode: MoPubErrorCode) {
        //showButton?.isEnabled = false
        callbacksAdapter?.notifyCallbackCalled(
            InterstitialCallbacks.FAILED.toString(),
            errorCode.toString()
        ) //?: Utils.logToast(activity, "Interstitial failed to load: $errorCode")

        if (moPubInterstitial == null || moPubInterstitial?.getAdUnitId().isNullOrEmpty()) {
            // Utils.logToast(activity, "Ad unit is not initialized")
            return
        }
        onDestroyView();

        InterstitialAdCallbackAndListeners.failedToShowRewardAdListener(_call, _notifyListenersFunction,errorCode);
        *//*val loadedAdUrl = LastAdRequestUrlManager.getAdRequestUrl(moPubInterstitial?.getAdUnitId())
        if (!loadedAdUrl.isNullOrEmpty()) {
            // viewHolder.shareButton?.isEnabled = true
        }*//*
    }

    override fun onInterstitialShown(interstitial: MoPubInterstitial) {
        //showButton?.isEnabled = false
        callbacksAdapter?.notifyCallbackCalled(InterstitialCallbacks.SHOWN.toString())
            //?: Utils.logToast(activity, "Interstitial shown.")
    }

    override fun onInterstitialClicked(interstitial: MoPubInterstitial) {
        callbacksAdapter?.notifyCallbackCalled(InterstitialCallbacks.CLICKED.toString())
            //?: Utils.logToast(activity, "Interstitial clicked.")
    }

    override fun onInterstitialDismissed(interstitial: MoPubInterstitial) {
        callbacksAdapter?.notifyCallbackCalled(InterstitialCallbacks.DISMISSED.toString())
            //?: Utils.logToast(activity, "Interstitial dismissed.")
        onDestroyView();
        InterstitialAdCallbackAndListeners.getOnUserEarnedRewardListener(_call, _notifyListenersFunction);
    }
*/
}
