package com.sudoku;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class to get the input as 2 dimensional array with 9x9 inputs
 *
 */
public class SukoduChecker {

	static Logger log = LogManager.getLogger(SukoduChecker.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[][] input = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 }, { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
//				{ 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 5, 6, 7, 8, 9, 1, 2, 3, 4 }, { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
//				{ 3, 4, 5, 6, 7, 8, 9, 1, 2 }, { 6, 7, 8, 9, 1, 2, 3, 4, 5 }, { 9, 1, 2, 3, 4, 5, 6, 7, 8 } };

		int[][] sudoku = parseSudokuInput(args);
		Validator validator = new Validator(sudoku); // Constructor which initializes with input filled sudoku

		// Calling the checker method in validator to check the filled sudoku is valid
		// or not
		if (validator.checker()) {
			log.info("Valid Sudoku");
		} else {
			log.info("Invalid Sudoku");
		}

	}

	/**
	 * @param args
	 * @return
	 */
	static int[][] parseSudokuInput(String[] args) {

		int[][] result = null;

		if (args.length < 1) {
			log.info("No File input provided");
			System.exit(1);
		}

		String inputFile = args[0];

		if ("".equals(inputFile)) {
			log.info("No File input provided");
			System.exit(1);
		}

		// check and read the file

		try (BufferedReader buffer = new BufferedReader(
				new InputStreamReader(new DataInputStream(new FileInputStream(inputFile))))) {

			// Check File exists
			File file = new File(inputFile);
			if (!file.exists()) {
				log.info("The give file doesn't exists. Please input the full path of the file!");
				System.exit(1);
			}

			String line;

			int noOfRows = 0;
			ArrayList<String> rows = new ArrayList<String>();

			// Read File Line By Line to array List
			while ((line = buffer.readLine()) != null) {
				rows.add(line);
			}

			noOfRows = rows.size();

			int noOfColumn = 0;

			// form the board from the string array list
			for (int i = 0; i < noOfRows; i++) {
				String row = rows.get(i);
				String[] strCols = row.split(",");
				noOfColumn = strCols.length;

				// validate given input is square
				if (noOfColumn != noOfRows) {
					log.info("No of rows should match the no of columns. Problem in line " + i
							+ " of the file");
					System.exit(1);
				}

				// initialize the board array only on the first iteration
				if (i == 0)
					result = new int[noOfRows][noOfColumn];

				// Fill the array
				for (int j = 0; j < strCols.length; j++) {
					Pattern pattern = Pattern.compile("[1-9]");
					Matcher match = pattern.matcher(strCols[j]);
					if(match.matches()) {
						result[i][j] = Integer.parseInt(strCols[j]);
					} else {
						log.info("Digits found other than 1 to 9, Invalid Filled Sudoku");
						System.exit(1);
					}
				}

			}

		} catch (IOException e) {
			log.info("Exception with input File. Provide valid file path");
		} catch (Exception ex) {
			log.info("Exception while File parsing." + ex.getMessage());
		}

		return result;
	}

}