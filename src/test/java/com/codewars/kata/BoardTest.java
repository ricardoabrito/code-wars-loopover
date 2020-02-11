package com.codewars.kata;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static com.codewars.kata.Move.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void shouldFlatMapGrid() {
        //given
        char[][] grid = {{'A', 'B', 'C', 'D'}, {'E', 'F', 'G', 'H'}, {'I', 'J', 'K', 'L'}};
        Board board = Board.of(grid);
        //when
        Stream<Point> points = board.points();
        //then
        points.forEach(p -> assertEquals(p.getValue(), grid[p.getRow()][p.getColumn()]));
    }

    @Test
    void shouldFlatMapAllInnerPoints() {
        //given
        char[][] grid = {{'A', 'B', 'C', 'D'}, {'E', 'F', 'G', 'H'}, {'I', 'J', 'K', 'L'}};
        Board board = Board.of(grid);
        //when
        Stream<Point> points = board.innerPoints();
        //then
        points.forEach(p -> assertFalse(p.onRow(2) && p.onColumn(3)));
    }

    @Test
    void shouldFlatMapAllOuterPoints() {
        //given
        char[][] grid = {{'A', 'B', 'C', 'D'}, {'E', 'F', 'G', 'H'}, {'I', 'J', 'K', 'L'}};
        Board board = Board.of(grid);
        //when
        Stream<Point> points = board.outerPoints();
        //then
        points.forEach(p -> assertTrue((p.onRow(2) || p.onColumn(3)) && p.notOnCorner()));
    }

    @Test
    void shouldTransformUP() {
        //given
        char[][] grid = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        char[][] transformedGrid = {{'A', 'E', 'C'}, {'D', 'H', 'F'}, {'G', 'B', 'I'}};
        //when
        Board board = Board.of(grid).transform(up(1));
        //then
       assertEquals(Board.of(transformedGrid), board);
    }

    @Test
    void shouldTransformDOWN() {
        //given
        char[][] grid = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        char[][] transformedGrid = {{'A', 'H', 'C'}, {'D', 'B', 'F'}, {'G', 'E', 'I'}};
        //when
        Board board = Board.of(grid).transform(down(1));
        //then
        assertEquals(Board.of(transformedGrid), board);
    }

    @Test
    void shouldTransformRIGHT() {
        //given
        char[][] grid = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        char[][] transformedGrid = {{'A', 'B', 'C'}, {'F', 'D', 'E'}, {'G', 'H', 'I'}};
        //when
        Board board = Board.of(grid).transform(right(1));
        //then
        assertEquals(Board.of(transformedGrid), board);
    }

    @Test
    void shouldTransformLEFT() {
        //given
        char[][] grid = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        char[][] transformedGrid = {{'A', 'B', 'C'}, {'E', 'F', 'D'}, {'G', 'H', 'I'}};
        //when
        Board board = Board.of(grid).transform(left(1));
        Board transformed = Board.of(transformedGrid);
        //then
        assertEquals(transformed, board);
    }

    @Test
    void shouldBeEqualsSameGrid() {
        //given
        char[][] grid = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        char[][] grid2 = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        //when
        Board board = Board.of(grid);
        Board board2 = Board.of(grid2);
        //then
        assertTrue(board.equals(board2));
    }


    @Test
    void shouldNotBeEqualsToDiferentGridSizes() {
        //given
        char[][] grid = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        char[][] grid2 = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}, {'J', 'K', 'L'}};
        //when
        Board board = Board.of(grid);
        Board board2 = Board.of(grid2);
        //then
        assertFalse(board.equals(board2));
    }

    @Test
    void shouldNotBeEqualsToAnotherClass() {
        //given
        char[][] grid = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        //when
        Board board = Board.of(grid);
        //then
        assertFalse(board.equals(new Object()));
    }

}
