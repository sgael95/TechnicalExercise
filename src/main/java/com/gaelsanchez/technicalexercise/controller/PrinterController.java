package com.gaelsanchez.technicalexercise.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.gaelsanchez.technicalexercise.model.LabelPrinter;

/**
 * This class is used to pass the path 
 * variable, contaning the file path, to 
 * a new LabelPrinter object.
 * 
 * @author Gael Sanchez
 *
 */
public class PrinterController {
	
	private LabelPrinter labelPrinter = new LabelPrinter();

	public void readFile(String filePath) throws IOException {
		InputStream inputStream = new FileInputStream(filePath);
		labelPrinter.print(inputStream);
	}
}
