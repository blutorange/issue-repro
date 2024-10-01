Simply run `npm install`, followed by `npm run build`.

```sh
git clone https://github.com/blutorange/issue-repro
cd issue-repro
git checkout issue-typescript-missing-type-param
npm install
npm run build
```

---

Given the input file `src/index.js`:

```js
/**
 * @template {0|1|2} T
 * @extends {Scope.sub.Box<T>}
 */
export class MyComponent extends Scope.sub.Box {
    more() {
        return "foo";
    }
}
```

TypeScript generate the following the declaration file `dist/index.d.ts`:

```ts
declare const MyComponent_base: typeof import("./header.js").Box;
/**
 * @template {0|1|2} T
 * @extends {Scope.sub.Box<T>}
 */
export class MyComponent<T extends 0 | 1 | 2> extends MyComponent_base {
    constructor();
    more(): string;
}
export {};
```

This is wrong. Typechecking this output gives the compile error

> Generic type 'Box<T>' requires 1 type argument(s).

The correct output should be 

```ts
declare const MyComponent_base: typeof import("./header.js").Box;
/**
 * @template {0|1|2} T
 * @extends {Scope.sub.Box<T>}
 */
export class MyComponent<T extends 0 | 1 | 2> extends MyComponent_base<T> {
    constructor();
    more(): string;
}
export {};
```
