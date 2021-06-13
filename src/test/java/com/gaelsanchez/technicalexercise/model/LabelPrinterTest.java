package com.gaelsanchez.technicalexercise.model;

import org.junit.Test;

public class LabelPrinterTest {
	boolean isPresent = false;
	
	@Test
	public void itShouldExtractDataFromStringArray() {
		// Given
		String[] stringArray = {"This"};
		LabelPrinter underTest = new LabelPrinter();
		TimeMap map = null;
		
		// When
		underTest.extractData(stringArray);
		map = underTest.getTimeMap();
		
		// Then
		map.getTimeMap().entrySet().forEach(entry -> {
			String s = "This";
			if(entry.getValue().get(0).getLabelContent() == s) {
				isPresent = true;
			}
		});
		
		assert(isPresent);
	}

}
