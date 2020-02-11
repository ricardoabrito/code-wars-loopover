package com.codewars.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Board {

	private char[][] grid;

	private final int cols;
	private final int rows;

	private final int lastColIndex;
	private final int lastRowIndex;

	private List<Point> points;

	private Board(char[][] grid) {

		this.grid = grid;
		this.cols = grid[0].length;
		this.rows = grid.length;

		this.lastColIndex = cols - 1;
		this.lastRowIndex = rows - 1;

		this.initPoints();
	}

	private void initPoints() {
		List<Point> points = new ArrayList<>(this.cols * this.rows);
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				points.add(Point.of(i, j, this.grid[i][j], isOnCorner(i, j)));
			}
		}
		this.points = points;
	}

	private boolean isOnCorner(int row, int col) {
		return row >= this.lastRowIndex - 1 && col >= this.lastColIndex - 1;
	}

	static Board of(char[][] grid) {
		return new Board(grid);
	}

	Board transform(Move move){
		char [][] newGrid = new char[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				newGrid[i][j] = newChar(move, i, j);
			}
		}
		return Board.of(newGrid);
	}

	Stream<Point> points() {
		return this.points.stream();
	}

	Stream<Point> innerPoints() {
		return points().filter(p -> p.notOnColumn(lastColIndex) && p.notOnRow(lastRowIndex));
	}

	Stream<Point> outerPoints() {
		return points().filter(p -> (p.onColumn(lastColIndex) || p.onRow(lastRowIndex)) && p.notOnCorner());
	}


	private char newChar(Move move, int row, int column) {
		if (move.isHorizontal()) {
			column = move.isIndex(row) ? shiftColumn(move, column) : column;
		} else {
			row = move.isIndex(column) ? shiftRow(move, row) : row;
		}
		return this.grid[row][column];
	}

	private int shiftColumn(Move move, int index) {
		return shift(move, index, cols);
	}

	private int shiftRow(Move move, int index) {
		return shift(move, index, rows);
	}

	private int shift(Move move, int index, int max) {
		return move.isNegative() ? negativeShift(index, max) : positiveShift(index, max);
	}

	private int negativeShift(int index, int max) {
		int shifted = index - 1;
		return shifted < 0 ? max - 1 : shifted;
	}
	private int positiveShift(int index, int max) {
		int shifted =  index + 1;
		return shifted == max ? 0 : shifted;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj instanceof Board) {
			Board other = (Board) obj;
			if (this.compareSize(other)) {
				return this.compareGrids(other.grid, this.rows, this.cols);
			} else { return false; }
		} else { return false; }
	}

	private boolean compareSize(Board board) {
		return this.cols == board.cols && this.rows == board.rows;
	}

	private boolean compareGrids(char[][] other, int rows, int cols) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if (this.grid[i][j] != other[i][j]) { return false; }
			}
		}
		return true;
	}

	/**
	 * For Debugging Purposes
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		Arrays.stream(grid).forEach(c -> {
			stringBuilder.append(c);
			stringBuilder.append("\n");
		});
		return stringBuilder.toString();
	}

}
