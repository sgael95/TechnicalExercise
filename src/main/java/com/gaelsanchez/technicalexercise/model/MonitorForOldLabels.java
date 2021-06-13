package com.gaelsanchez.technicalexercise.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TimerTask;

/**
 * This class is used to monitor a map 
 * containing labels stored by the time 
 * they were read plus 10 seconds.
 * @author Gael Sanchez
 *
 */
public class MonitorForOldLabels extends TimerTask{
	
	private TimeMap timeMap;
	private LocalDateTime now;
	private ArrayList<Label> labels;
	
	MonitorForOldLabels(TimeMap timeMap){
		this.timeMap = timeMap;
	}
	
	@Override
	public void run() {
		now = LocalDateTime.now().withNano(0);
		if(timeMap.containsLabelsAtTime(now)) {
			labels = timeMap.getAllLabelsAtTime(now);
			for(Label label: labels) {
				System.out.println(label+" is now 10 seconds old.");
			}
		}
	}

}
