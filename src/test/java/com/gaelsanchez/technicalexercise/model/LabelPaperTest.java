package com.gaelsanchez.technicalexercise.model;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LabelPaperTest {
	
	@Test
	public void itShouldAddStringToLabelPaper() {
		// Given
		LabelPaper underTest = new LabelPaper(1, 6);
		int added = 0;
		char[] expectedArray = {'S', 't', 'r', 'i', 'n', 'g'};
		char[] actualArray = new char[6];
		
		// When
		added = underTest.addString("String");
		 // Loop through all rows
		char[][] matrix = underTest.getMatrix();
        for (int i = 0; i < matrix.length; i++)
 
            // Loop through all elements of current row
            for (int j = 0; j < matrix[i].length; j++)
                actualArray[j] = matrix[i][j];
		
		// Then
		assert(added == 1);
		assertArrayEquals(expectedArray, actualArray);
	}
	
	@Test
	public void itShouldNotAddStringToLabelPaper() {
		// Given
		LabelPaper underTest = new LabelPaper(1, 5);
		int added = 0;
		
		// When
		added = underTest.addString("String");
		
		// Then
		assert(added != 1);
	}
	
	@Test
	public void itShouldNotAddWhenWidthExceedsLimit() {
		// Given
		LabelPaper underTest = new LabelPaper(1, 6);
		int added = 0;
		
		// When
		added = underTest.addString("String");
		added = underTest.addString("String");
		
		//Then
		assert(added != 1);
	}
	
	@Test
	public void itShouldNotAddeWhenLengthExceedsLimit() {
		// Given
		LabelPaper underTest = new LabelPaper(1, 11);
		int added = 0;
		
		//When
		added = underTest.addString("String");
		added = underTest.addString("String");
		
		
		// Then
		assert(added != 1);
	}
	
	@Test
	public void itShouldAddWhenCurrentRowIsFull() {
		// Given
		LabelPaper underTest = new LabelPaper(2, 11);
		int added = 0;
		
		// When
		added = underTest.addString("String");
		added = underTest.addString("String");
		
		// Then
		assert(added == 1);
	}
	
	@Test
	public void itShouldNotAddedAndReturnFull() {
		// Given
		LabelPaper underTest = new LabelPaper(2, 11);
		int added = 0;
		boolean isFull = false;
		
		// When
		added = underTest.addString("String");
		added = underTest.addString("String");
		added = underTest.addString("String");
		isFull = underTest.isFull();
		
		// Then
		assert(added != 1);
		assert(isFull);
		
	}

}
