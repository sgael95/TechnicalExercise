package com.gaelsanchez.technicalexercise.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

public class TimeMapTest {

	@Test
	public void itShouldAddLabelAtTimeKey() {
		// Given
		LocalDateTime time = LocalDateTime.now().withNano(0);
		TimeMap underTest = new TimeMap();
		Label label = new Label(time, 1, "String");
		boolean present = false;
		LocalDateTime plusSeconds = time.plusSeconds(10);
		
		// When
		underTest.add(time, label);
		
		// Then
		present = underTest.getTimeMap().containsKey(plusSeconds);
		
		assert(present == true);
	}
	
	@Test
	public void itShouldAddLabelsAtSameTimeKey() {
		// Given
		LocalDateTime time = LocalDateTime.now().withNano(0);
		TimeMap underTest = new TimeMap();
		Label label = new Label(time, 1, "String");
		Label label2 = new Label(time, 2, "Second String");
		boolean present = false;
		LocalDateTime plusSeconds = time.plusSeconds(10);
		
		// When
		underTest.add(time, label);
		underTest.add(time, label2);
		
		// Then
		present = underTest.getTimeMap().get(plusSeconds).contains(label);
		assert(present == true);
		present = underTest.getTimeMap().get(plusSeconds).contains(label2);
		assert(present == true);
	}
	
	@Test
	public void itShouldReturnTrueWhenTimeKeyContainsLabels() {
		// Given
		LocalDateTime time = LocalDateTime.now().withNano(0);
		TimeMap underTest = new TimeMap();
		Label label = new Label(time, 1, "String");
		boolean present = false;
		LocalDateTime plusSeconds = time.plusSeconds(10);
		
		// When
		underTest.add(time, label);
		
		// Then
		present = underTest.containsLabelsAtTime(plusSeconds);
		
		assert(present == true);
	}
	
	@Test
	public void itShouldReturnFalseWhenTimeKeyContainsNoLabels() {
		// Given
		LocalDateTime time = LocalDateTime.now().withNano(0);
		TimeMap underTest = new TimeMap();
		Label label = new Label(time, 1, "String");
		boolean present = false;
		LocalDateTime plusSeconds = time.plusSeconds(15);
		
		// When
		underTest.add(time, label);
		
		// Then
		present = underTest.containsLabelsAtTime(plusSeconds);
		assert(present != true);
	}
	
	@Test
	public void itShouldReturnListAtTimeKeyAndRemoveFromMap() {
		// Given
		LocalDateTime time = LocalDateTime.now().withNano(0);
		TimeMap underTest = new TimeMap();
		Label label = new Label(time, 1, "String");
		ArrayList<Label> present;
		LocalDateTime plusSeconds = time.plusSeconds(10);
		
		// When
		underTest.add(time, label);
		
		// Then
		present = underTest.getAllLabelsAtTime(plusSeconds);
		
		assert(present.contains(label));
		assert(!underTest.containsLabelsAtTime(time));
	}
}
