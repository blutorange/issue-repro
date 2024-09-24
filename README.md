Illustrates https://github.com/alibaba/fastjson2/issues/2981

Just clone and run `mvn test`.

`JSON.toJSON(x)` should always be equivalent to `JSON.parse(JSON.toJSONString(x))`,
but when used with `@JSONType(typeKey = "...")` on a class with sub classes,
the `typeKey` is missing when using `JSON.toJSON`.
