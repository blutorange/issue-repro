import { promises as fs } from 'node:fs';
import { fileURLToPath } from 'node:url';
import { join } from 'node:path';

const dirname = fileURLToPath(new URL('.', import.meta.url));

await fs.copyFile(join(dirname, "..", "src", "global.d.ts"), join(dirname, "..", "dist", "global.d.ts"));
await fs.copyFile(join(dirname, "..", "src", "header.d.ts"), join(dirname, "..", "dist", "header.d.ts"));
