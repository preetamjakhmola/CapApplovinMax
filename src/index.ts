import { registerPlugin } from '@capacitor/core';

import type { CapApplovinMaxPlugin } from './definitions';

const CapApplovinMax = registerPlugin<CapApplovinMaxPlugin>('CapApplovinMax', {
  web: () => import('./web').then(m => new m.CapApplovinMaxWeb()),
});

export * from './definitions';
export { CapApplovinMax };
