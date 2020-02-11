package com.codewars.kata;

import java.util.Arrays;

class Board {

	private char[][] grid;

	private final int cols;
	private final int rows;

	private Board(char[][] grid) {
		this.grid = grid;
		this.cols = grid[0].length;
		this.rows = grid.length;
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
		this.grid = newGrid;
		return this;
	}

	private char newChar(Move move, int row, int column) {
		if (move.isHorizontal()) {
			row = move.isIndex(column) ? shiftRow(move, row) : row;
		} else {
			column = move.isIndex(row) ? shiftColumn(move, column) : column;
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
		int shifted =  index - 1;
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

	void print() {
		Arrays.stream(grid).forEach(c -> {
			System.out.println(c);
		});
	}
}
