import { WebPlugin } from '@capacitor/core';

import type { CapApplovinMaxPlugin } from './definitions';

export class CapApplovinMaxWeb extends WebPlugin implements CapApplovinMaxPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
