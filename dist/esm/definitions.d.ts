export interface SharePlugin {
    share(options: {
        text: string;
        filename?: string;
    }): Promise<{
        value: string;
    }>;
}
