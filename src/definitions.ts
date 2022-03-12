
import { InterstitialDefinitions } from "./interstitial";
import { IBannerDefinitions } from "./banner";


import { AdOptions } from "./shared/ad-options.interface";

type CapAdDefinitions = IBannerDefinitions & InterstitialDefinitions;
export interface CapApplovinMaxPlugin extends CapAdDefinitions {
  initialize(options: AdOptions): Promise<void>;

}

export interface CapAdInitializationOptions {
  /**
   * Use or not requestTrackingAuthorization in iOS(>14)
   * 
   */
  requestTrackingAuthorization?: boolean;

  /* 
   */
  testingDevices?: string[];

  /**
   * @default false 
   */
  initializeForTesting?: boolean;
}