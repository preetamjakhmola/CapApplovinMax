import { WebPlugin } from '@capacitor/core';

import type { CapApplovinMaxPlugin } from './definitions';
import { AdLoadInfo, AdOptions, AdRewardItem } from './shared';

export class CapApplovinMaxWeb extends WebPlugin implements CapApplovinMaxPlugin {

  constructor() {
    super({
      name: 'CapApplovinMax',
      platforms: ['web'],
    });
  }

  async initialize(): Promise<void> {
    console.log('initialize');
  }


  async showInterstitial(): Promise<AdRewardItem> {
    return {
      type: '',
      amount: 0,
    };
  }

  async showBanner(options: AdOptions): Promise<void> {
    console.log('showBanner', options);
  }

  // Hide the banner, remove it from screen, but can show it later
  async hideBanner(): Promise<void> {
    console.log('hideBanner');
  }

  // Resume the banner, show it after hide
  async resumeBanner(): Promise<void> {
    console.log('resumeBanner');
  }

  // Destroy the banner, remove it from screen.
  async removeBanner(): Promise<void> {
    console.log('removeBanner');
  }

  async prepareRewardVideoAd(options: AdOptions): Promise<AdLoadInfo> {
    console.log(options);
    return {
      adUnitId: options.adId,
    };
  }

  async showRewardVideoAd(): Promise<AdRewardItem> {
    return {
      type: '',
      amount: 0,
    };
  }
}
