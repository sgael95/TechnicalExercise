package com.gaelsanchez.technicalexercise.model;

import java.time.LocalDateTime;

/**
 * This class is used to create a label 
 * object. A label will contain a time stamp,
 * a label id and the content for the label.
 * 
 * @author Gael Sanchez
 *
 */
public class Label {
	
	private LocalDateTime timeStamp;
	private int	labelId;
	private String labelContent;
	
	
	Label(LocalDateTime timeStamp,
			int labelId,
			String labelContent){
		this.timeStamp = timeStamp;
		this.labelId = labelId;
		this.labelContent = labelContent;
	}


	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}


	public int getLabelId() {
		return labelId;
	}


	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}


	public String getLabelContent() {
		return labelContent;
	}


	public void setLabelContent(String labelContent) {
		this.labelContent = labelContent;
	}


	@Override
	public String toString() {
		return "Label [timeStamp=" + timeStamp + ", labelId=" + labelId + ", labelContent=" + labelContent + "]";
	}

}
