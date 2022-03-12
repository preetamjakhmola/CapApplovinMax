import { registerPlugin } from '@capacitor/core';

import type { CapApplovinMaxPlugin } from './definitions';

const CapApplovinMax = registerPlugin<CapApplovinMaxPlugin>('CapApplovinMax', {
  web: () => import('./web').then(m => new m.CapApplovinMaxWeb()),
});

export * from './definitions';
export * from './banner/index';
export * from './interstitial/index';
export * from './shared/index';
export { CapApplovinMax };
