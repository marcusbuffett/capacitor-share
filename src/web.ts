import { WebPlugin } from '@capacitor/core';

import type { SharePlugin } from './definitions';

export class ShareWeb extends WebPlugin implements SharePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
