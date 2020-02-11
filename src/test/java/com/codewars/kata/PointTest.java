package com.codewars.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void shouldBeEquals() {
        //given
        Point p1 = Point.of(1, 2, 'a', false);
        Point p2 = Point.of(3, 5, 'a', true);
        //when
        boolean test = p1.equals(p2);
        //then
        assertTrue(test);
    }

    @Test
    void shouldNotBeEquals() {
        //given
        Point p1 = Point.of(1, 2, 'a', false);
        Point p2 = Point.of(1, 2, 'b', false);
        //when
        boolean test = p1.equals(p2);
        //then
        assertFalse(test);
    }

    @Test
    void shouldNotBeEqualsToAnotherObject() {
        //given
        Point p1 = Point.of(1, 2, 'a', false);
        //when
        boolean test = p1.equals(new Object());
        //then
        assertFalse(test);
    }
}
