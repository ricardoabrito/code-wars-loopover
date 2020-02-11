package com.codewars.kata;

import java.util.ArrayList;
import java.util.List;

import static com.codewars.kata.Move.UP;

public class Solver {

	List<String> moves = new ArrayList<>();

	public List<String> solve(Board mixedUp, Board solved) {
		if (mixedUp.equals(solved)) { return moves; }
		solved.innerPoints().forEach(p -> System.out.println(p.getValue()));
//		solved.outerPoints().forEach(p -> System.out.println(p.getValue()));
		return  moves;
	}
}
