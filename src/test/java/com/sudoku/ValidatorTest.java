package com.sudoku;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {

	Validator validator = null;
	
	Validator validator1 = null;
	@Before
	public void setUp() throws Exception {
		
		int[][] input={{5,3,4,6,7,8,9,1,2},
				{6,7,2,1,9,5,3,4,8},
				{1,9,8,3,4,2,5,6,7},
				{8,5,9,7,6,1,4,2,3},
				{4,2,6,8,5,3,7,9,1},
				{7,1,3,9,2,4,8,5,6},
				{9,6,1,5,3,7,2,8,4},
				{2,8,7,4,1,9,6,3,5},
				{3,4,5,2,8,6,1,7,9}};
		
		validator = new Validator(input);
		int[][] input1={{5,3,4,6,7,8,9,1,1},
				{6,7,2,1,9,5,3,4,8},
				{1,9,8,3,4,2,5,6,7},
				{8,5,9,7,6,1,4,2,3},
				{4,2,6,8,5,3,7,9,1},
				{7,1,3,9,2,4,8,5,6},
				{9,6,1,5,3,7,2,8,4},
				{2,8,7,4,1,9,6,3,5},
				{3,4,5,2,8,6,1,7,9}};
		
		validator1 = new Validator(input1);
		
		 HashSet<Integer> rows = null; 
		
		HashSet<Integer> columns = null;
		
		HashSet<Integer> grids = null;
		
		ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
		
		for (int i = 0; i < 27; i++) {
			list.add(new HashSet<Integer>()); 
			}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testcheckerTrue() {
		assertTrue(validator.checker());
	}

	@Test
	public void testcheckerFalse() {
		assertFalse(validator1.checker());
	}
}
