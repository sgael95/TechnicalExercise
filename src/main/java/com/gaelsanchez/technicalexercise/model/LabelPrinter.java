package com.gaelsanchez.technicalexercise.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * This class allows for the creation of a 
 * label printer object that can be used to 
 * organize the printing of labels. This 
 * class implements a Printer interface
 * containing a single print method.
 * 
 * @author Gael Sanchez
 *
 */
public class LabelPrinter implements Printer {
	
	private TimeMap timeMap;
	private LabelPaper labelPaper;
	private Timer timer;
	
	public LabelPrinter() {
		timeMap = new TimeMap();
		labelPaper = new LabelPaper(8, 128);
		timer = new Timer();
	}

	public TimeMap getTimeMap() {
		return timeMap;
	}

	public void setTimeMap(TimeMap timeMap) {
		this.timeMap = timeMap;
	}

	public LabelPaper getLabelPaper() {
		return labelPaper;
	}

	public void setLabelPaper(LabelPaper labelPaper) {
		this.labelPaper = labelPaper;
	}

	/**
	 * This method will take an input stream and
	 *  start two threads. The first thread will pass 
	 *  the input stream to method that will handle input. 
	 *  The second thread will start a monitor that will 
	 *  monitor the hash map storing the time a label was 
	 *  read. It will print to the console when a label 
	 *  has waited 10 seconds.
	 */
	public void print(InputStream in) {
		new Thread(() -> {
			readData(in);
		}).start();
		
		new Thread(() -> {
			timer.schedule(new MonitorForOldLabels(timeMap), 0,  1000);
		}).start();
		return;
	}
	
	/**
	 * This method takes the input stream and 
	 * reads each character from the stream. 
	 * It will implement a buffer of 1024 
	 * characters. Content will be sent to 
	 * separate method to extract data.
	 * @param in Input stream object containing data
	 */
	public void readData(InputStream in) {
		Reader reader = null;
		try {
			reader =
			    new BufferedReader(
			        new InputStreamReader(in));
		
			char[] theChars = new char[1024];
		
			int charsRead = reader.read(theChars, 0, theChars.length);
			while(charsRead != -1) {
				
				if(charsRead == theChars.length) {
					System.out.println("Buffer is full");
				}
				
				String fileText = new String(theChars, 0, charsRead);
				String[] stringArray = fileText.split("\\W+");
				extractData(stringArray);
			    charsRead = reader.read(theChars, 0, theChars.length);
			}
			timer.cancel();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader != null)
					reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * This method will take an array of stings 
	 * and create a label object from each entry.
	 * This label will then be stored in the map 
	 * storing labels by their time and will place 
	 * the label on the label paper if it fits, 
	 * if it does not, it will be placed on another 
	 * sheet of label paper.
	 * @param stringArray
	 */
	public void extractData(String[] stringArray) {
		LocalDateTime time;
		Label label;
		
		for(int i = 0; i < stringArray.length; i++) {
			
			if(labelPaper.isFull()) {
				printLabelPaper(labelPaper);
				labelPaper = new LabelPaper(8, 128);
			}
			
			/**
			 * This section can be uncommented to add a second delay between
			 * each entry. This will allow for monitor to find entries
			 * older than 10 seconds.
			 
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			*/
			
			time = LocalDateTime.now();
			label = new Label(time, i, stringArray[i]);
			timeMap.add(time, label);
			labelPaper.addString(stringArray[i] + " ");
		}
		printLabelPaper(labelPaper);
	}
	
	
	/**
	 * This method should be used to execute the print
	 * action on the physical printer.
	 * @param labelPaper
	 */
	public void printLabelPaper(LabelPaper labelPaper) {
		// TO-DO: Implement a feature to print label paper on printer.
		
		/**
		 * This comment can be removed to have the label paper 
		 * printed to the console simulating how it would
		 * theoretically be printed on an actual sheet of label paper.
		 * 
		 
		char[][] mat = labelPaper.getMatrix();
		
		// Loop through all rows
        for (int i = 0; i < mat.length; i++)
 
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++) 
            	System.out.print(mat[i][j] + " ");
            	
          */
            
	}

}
