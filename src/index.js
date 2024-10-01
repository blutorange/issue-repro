/**
 * @template {0|1|2} T
 * @extends {Scope.sub.Box<T>}
 */
export class MyComponent extends Scope.sub.Box {
    more() {
        return "foo";
    }
}