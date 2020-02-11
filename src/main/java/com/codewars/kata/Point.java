package com.codewars.kata;

class Point {
		private final int row;
		private final int column;
		private final char value;
		private final boolean corner;

		private Point(int row, int column, char value, boolean corner) {
			this.row = row;
			this.column = column;
			this.value = value;
			this.corner = corner;
		}

		public static Point of(int row, int column, char value, boolean corner) {
			return new Point(row, column, value, corner);
		}

		public int getRow() {
			return row;
		}

		public int getColumn() {
			return column;
		}

		public char getValue() {
			return value;
		}

		public boolean onColumn(int column) {
			return this.column == column;
		}

		public boolean onRow(int row) {
			return this.row == (row);
		}

		public boolean onCorner() {
			return corner;
		}

	public boolean notOnCorner() {
		return !onCorner();
	}

		public boolean notOnColumn(int column) {
			return !onColumn(column);
		}

		public boolean notOnRow(int row) {
			return !onRow(row);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) { return true; }
			if (obj instanceof Point) {
				Point other = (Point) obj;
				return this.value == other.value;
			} else { return false; }
		}
	}
