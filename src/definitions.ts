export interface CapApplovinMaxPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
