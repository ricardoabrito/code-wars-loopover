package com.codewars.kata;

public class Move {

	private final int index;
	private final boolean horizontal;
	private final boolean negative;
	private final String name;

	private Move(boolean horizontal, boolean negative, String name, int index) {
		this.horizontal = horizontal;
		this.negative = negative;
		this.name = name;
		this.index = index;
	}

	static Move up(int index) {
		return new Move(false, false, "U", index);
	}

	static Move down(int index) {
		return new Move(false, true, "D", index);
	}

	static Move right(int index) {
		return new Move(true, true, "R", index);
	}

	static Move left(int index) {
		return new Move(true, false, "L", index);
	}

	boolean isHorizontal() {
		return this.horizontal;
	}

	boolean isNegative() {
		return this.negative;
	}

	boolean isIndex(int index) {
		return this.index == index;
	}

	@Override
	public String toString() {
		return this.name + this.index;
	}
}
