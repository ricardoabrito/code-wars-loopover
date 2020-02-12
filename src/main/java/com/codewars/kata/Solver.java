package com.codewars.kata;

import java.util.ArrayList;
import java.util.List;

public class Solver {

	List<String> moves = new ArrayList<>();

	public List<String> solve(Board mixedUp, Board solved) {
		if (mixedUp.equals(solved)) { return moves; }
		solved.innerPoints().forEach(p -> solveInnerSquare(mixedUp, p));
		return  moves;
	}

	private Board solveInnerSquare(Board board, Point point){
		return null;
	}

}
