package com.codewars.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LoopoverTest {

	@Test
	@DisplayName("Teste base para solucionar desafio Loopover")
	void test() {
		Loopover.solve(mixGrid(), solvedGrid());
	}

	private char[][] mixGrid() {
		char[][] mixGrid = {{'K', 'C', 'E', 'J'}, {'B', 'D', 'F', 'A'}, {'H', 'G', 'I', 'L'}};
		return mixGrid;
	}

	private char[][] solvedGrid() {
		char[][] solvedGrid = {{'A', 'B', 'C', 'D'}, {'E', 'F', 'G', 'H'}, {'I', 'J', 'K', 'L'}};
		return solvedGrid;
	}

}
