import type { Box } from "./header.d.ts";

declare global {
    export const Scope: {
        sub: {
            Box: typeof Box,
        }
    };
}