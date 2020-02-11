package com.codewars.kata;

import org.junit.jupiter.api.Test;

import static com.codewars.kata.Move.*;
import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    void upString() {
        assertEquals("U2", up(2).toString());
    }
    @Test
    void downString() {
        assertEquals("D2", down(2).toString());
    }
    @Test
    void rightString() {
        assertEquals("R2", right(2).toString());
    }
    @Test
    void leftString() {
        assertEquals("L2", left(2).toString());
    }

}
