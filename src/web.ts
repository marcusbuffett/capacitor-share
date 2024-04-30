import { WebPlugin } from "@capacitor/core";

import type { SharePlugin } from "./definitions";

export class ShareWeb extends WebPlugin implements SharePlugin {
	async share(_options: { text: string; filename?: string }): Promise<{
		value: string;
	}> {
		return { value: "success" };
	}
}
