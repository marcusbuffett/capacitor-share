import { WebPlugin } from "@capacitor/core";
import type { SharePlugin } from "./definitions";
export declare class ShareWeb extends WebPlugin implements SharePlugin {
    share(_options: {
        text: string;
        filename?: string;
    }): Promise<{
        value: string;
    }>;
}
