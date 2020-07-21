package com.sudoku;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author 
 *
 */
class Validator {
	
	int[][] input;
	
	/**
	 * hashset to have unique row values
	 */
	private HashSet<Integer> rows = null; 
	
	/**
	 * hashset to have unique column values
	 */
	private HashSet<Integer> columns = null;
	
	/**
	 * hashset to have unique sub grid 3x3 values
	 */
	private HashSet<Integer> grids = null;
	
	/**
	 * ArrayList to hold the hashset of rows, columns and sub grid  to have unique values
	 */
	private ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();

	
	/**
	 * Initializes the 9x9 array for validation
	 */
	public Validator() {
		input = new int[9][9];
	}

	/**
	 * Fills the 9x9 array with values for validation
	 */
	public Validator(int[][] sudoku) {
		this.input = sudoku;
	}

	/**
	 * @return boolean 
	 * Checks the Sudoku filled is valid or not by iterating through 9x9 rows and columns 
	 */
	public boolean checker() {
		for (int i = 0; i < 27; i++) {
			list.add(new HashSet<Integer>()); //creates list of HashSet to have unique values in rows(9), columns(9) and subgrid(9) so 9x3 = 27
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!isValid(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Validator which uses the ArrayList of hashset to check for duplicate values in rows , columns and sub grid 3x3
	 */
	private boolean isValid(int row, int col) {

		rows = list.get(row);
		columns = list.get(9 + col);

		int subgrid = 3 * (row / 3) + (col / 3); //For subgrid
		grids = list.get(18 + subgrid);

		return (rows.add(input[row][col]) && columns.add(input[row][col]) && grids.add(input[row][col]));
	}

	
}