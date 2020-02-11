package com.codewars.kata;

enum Move {

	UP(true, false, "U"),
	DOWN(true, true, "D"),
	LEFT(false, false, "L"),
	RIGHT(false, true, "R"),;

	private Integer index;

	private final boolean horizontal;
	private final boolean negative;
	private final String name;

	Move(boolean horizontal, boolean negative, String name) {
		this.horizontal = horizontal;
		this.negative = negative;
		this.name = name;
	}

	Move on(int index) {
		if (this.index == null) {
			this.index = index;
		}
		return this;
	}

	boolean isHorizontal() {
		return this.horizontal;
	}

	boolean isNegative() {
		return this.negative;
	}

	boolean isIndex(int index) {
		return this.index.equals(index);
	}

	@Override
	public String toString() {
		return this.name + this.index;
	}
}
