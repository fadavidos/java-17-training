package com.fabian.osorio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SealedClassTest {

    sealed class Shape permits Circle, Square, Triangle {}

    final class Circle extends Shape {
        public float radious;
    }

    final class Square extends Shape {
        public double side = 8D;
    }

    final class Triangle extends Shape {
        public double height, base;
    }

    // 'Other' is not allowed in the sealed hierarchy
    // final class Other extends Shape { }

    @Test
    void usingASealedClass(){
        Square square = new Square();
        assertEquals(square.side, 8D);
    }

    @Test
    void testShapeHierarchy() {
        Shape circle = new Circle();
        Shape square = new Square();
        Shape triangle = new Triangle();

        assertTrue(circle instanceof Circle);
        assertTrue(square instanceof Square);
        assertTrue(triangle instanceof Triangle);
    }

}
