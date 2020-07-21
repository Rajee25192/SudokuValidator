package com.sudoku;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SukoduCheckerTest {

	SukoduChecker sudo = new SukoduChecker();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testmain_by_passing_args() throws Exception {
		String[] fileName = {"sudoku_filled.txt"};
		SukoduChecker.main(fileName);
	}
	
	@Test
	public void testparseSudokuInputwithFile() throws Exception {
		int [][] expected = {{5,3,4,6,7,8,9,1,2},
				{6,7,2,1,9,5,3,4,8},
				{1,9,8,3,4,2,5,6,7},
				{8,5,9,7,6,1,4,2,3},
				{4,2,6,8,5,3,7,9,1},
				{7,1,3,9,2,4,8,5,6},
				{9,6,1,5,3,7,2,8,4},
				{2,8,7,4,1,9,6,3,5},
				{3,4,5,2,8,6,1,7,9}};
		String[] fileName = {"sudoku_filled.txt"};
		SukoduChecker.parseSudokuInput(fileName);
		assertArrayEquals(expected, SukoduChecker.parseSudokuInput(fileName));
	}
	
	@Test(expected = Exception.class)
	public void testparseSudokuInputwithOutfile() throws Exception {
		
		String[] fileName = {""};
		SukoduChecker.parseSudokuInput(fileName);
	}
	
	@Test
	public void testparseSudokuInputwithwrongdata() throws Exception {
		
     	String[] fileName = {"sudoku_filledwrong1.txt"};
		SukoduChecker.parseSudokuInput(fileName);
		assertNull(SukoduChecker.parseSudokuInput(fileName));
	}

}
