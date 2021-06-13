package com.gaelsanchez.technicalexercise;

import java.io.IOException;

import com.gaelsanchez.technicalexercise.controller.PrinterController;

public class Application {

	public static void main(String[] args) throws IOException {
		
		String filePath = args[0];
		PrinterController controller = new PrinterController();
		controller.readFile(filePath);
		
	}

}
