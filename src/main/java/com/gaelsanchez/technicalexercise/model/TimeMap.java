package com.gaelsanchez.technicalexercise.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to create a time map 
 * object where labels can be stored in a 
 * hash map with a key of the time the where 
 * read plus 10 seconds. This makes it quick 
 * and easy to find any label at a given time.
 * @author sgael
 *
 */
public class TimeMap {
	private Map<LocalDateTime, ArrayList<Label>> timeMap;
	
	public TimeMap(){
		timeMap = new HashMap<LocalDateTime, ArrayList<Label>>();
	}

	public Map<LocalDateTime, ArrayList<Label>> getTimeMap() {
		return timeMap;
	}

	public void setTimeMap(Map<LocalDateTime, ArrayList<Label>> timeMap) {
		this.timeMap = timeMap;
	}
	
	/**
	 * This method will take in LocalDateTime variable and 
	 * a label object and added them to a hash map storing all
	 * entries based on the time it was read by the label printer
	 * object.
	 * @param time Type LocalDateTime, this is the time the label
	 *  was read by the printer.
	 * @param label Label object with time it was read, an identification
	 *  number and a string containing the label information.
	 */
	public synchronized void add(LocalDateTime time, Label label) {
		time = time.plusSeconds(10).withNano(0);
		List<Label> itemList = timeMap.get(time);
		
		if(itemList == null) {
			itemList = new ArrayList<Label>();
			itemList.add(label);
			timeMap.put(time, (ArrayList<Label>) itemList);
		} else {
			if(!itemList.contains(label)) itemList.add(label);
		}
		
	}
	
	/**
	 * This method returns true if time matches a key in the hash map
	 * @param time Type LocalDateTime, is the time when a label will
	 *  have been waiting 10 seconds.
	 * @return boolean value determined by parameter matching an entry
	 *  in the hash map.
	 */
	public synchronized boolean containsLabelsAtTime(LocalDateTime time) {
		return timeMap.containsKey(time);
	}
	
	/**
	 * This will fetch all labels that match the specified time.
	 * @param time Type LocalDateTime, is the time when a label will
	 *  have been waiting 10 seconds.
	 * @return ArrayList with label objects in the specified time.
	 */
	public synchronized ArrayList<Label> getAllLabelsAtTime(LocalDateTime time){
		ArrayList<Label> labels = timeMap.get(time);
		timeMap.remove(time);
		return labels;
	}

	@Override
	public String toString() {
		return "TimeMap [timeMap=" + timeMap + "]";
	}

}
