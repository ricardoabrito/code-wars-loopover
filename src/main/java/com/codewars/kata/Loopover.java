package com.codewars.kata;

import java.util.List;

/**
 * 	1. Primeiro devo solucionar o quadrado interior sem a última coluna e linha
 * 	2. Depois solucionar todos os valores da ultima coluna e linha sem mexer no
 * 	   quadrado interior e ignorando o as três casas adjacentes ao canto inferior
 * 	   direito
 * 	3. Por três vezes repetir o algoritimo em uma matrix n x m  Un Lm Dn Rm, caso
 * 	   em nenhuma das três tentativas o problema seja resolvido ele é insolúvel
 */
public class Loopover {
	public static List<String> solve(char[][] mixedUpBoard, char[][] solvedBoard) {
		return new Solver().solve(Board.of(mixedUpBoard), Board.of(solvedBoard));
	}
}





