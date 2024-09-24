package com.example;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.annotation.JSONType;

@JSONType(typeKey = "type", seeAlso = {Shape.Triangle.class, Shape.Circle.class})
public class Shape {
    @JSONType(typeKey = "type", typeName = "triangle", serializeFeatures = JSONWriter.Feature.WriteClassName)
    public static class Triangle extends Shape {
        private int a;
        private int b;
        private int c;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
    }

    @JSONType(typeKey = "type", typeName = "circle", serializeFeatures = JSONWriter.Feature.WriteClassName)
    public static class Circle extends Shape {
        private int radius;

        public int getRadius() {
            return radius;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }
    }
}
