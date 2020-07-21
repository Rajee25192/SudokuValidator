package com.sudoku;

/**
 * Class to get the input as 2 dimensional array with 9x9 inputs
 *
 */
public class SukoduChecker {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] input = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 4, 5, 6, 7, 8, 9, 1, 2, 3 },
				{ 7, 8, 9, 1, 2, 3, 4, 5, 6 },
				{ 2, 3, 4, 5, 6, 7, 8, 9, 1 }, 
				{ 5, 6, 7, 8, 9, 1, 2, 3, 4 },
				{ 8, 9, 1, 2, 3, 4, 5, 6, 7 },
				{ 3, 4, 5, 6, 7, 8, 9, 1, 2 }, 
				{ 6, 7, 8, 9, 1, 2, 3, 4, 5 }, 
				{ 9, 1, 2, 3, 4, 5, 6, 7, 8 } };

		Validator validator = new Validator(input); //Constructor which initializes with input filled sudoku

		//Calling the checker method in validator to check the filled sudoku is valid or not
		if (validator.checker()) {
			System.out.println("Valid Sudoku");
		} else {
			System.out.println("Invalid Sudoku");
		}

	}
}