export interface SharePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
