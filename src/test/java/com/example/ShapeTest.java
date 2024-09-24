package com.example;

import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeTest {
    /**
     * Issue: JSON.toJSON should be equivalent to JSON.parse(JSON.toJSONString).
     * Should: The resulting JSONObject should contain the same keys and values.
     * Is: The type key is missing when using JSON.toJSON.
     */
    @Test
    public void issueFastJson2_ToJson_Differs_From_ToJsonString() {
        var circle = new Shape.Circle();
        circle.setRadius(5);
        assertEquals(JSON.parse(JSON.toJSONString(circle)), JSON.toJSON(circle));
    }
}
