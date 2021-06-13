package com.gaelsanchez.technicalexercise.model;

import java.util.Arrays;

/**
 * This class allows for the creation of a grid 
 * layout on a sheet of label paper. To do this 
 * it uses a matrix of characters.
 * 
 * @author Gael Sanchez
 *
 */
public class LabelPaper {
	private char[][] matrix;
	private int length;
	private int width;
	private int lengthCount;
	private int widthCount;
	private boolean full;
	
	public LabelPaper(int width, int length){
		matrix = new char[width][length];
		this.length = length;
		this.width = width;
		lengthCount = 0;
		widthCount = 0;
		full = false;
	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(char[][] matrix) {
		this.matrix = matrix;
	}

	public int getLengthCount() {
		return lengthCount;
	}

	public void setLengthCount(int lengthCount) {
		this.lengthCount = lengthCount;
	}

	public int getWidthCount() {
		return widthCount;
	}

	public void setWidthCount(int widthCount) {
		this.widthCount = widthCount;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * This method will take a string and determine if 
	 * the string can fit in the available space. If the 
	 * string can not fit on the sheet of label paper 
	 * the full attribute will be set to true, no longer 
	 * allowing labels to be placed on it.
	 * @param s Label content being placed on sheet of 
	 * label paper.
	 * @return 1 if label was successfully placed and 
	 * 0 if it was not.
	 */
	public int addString(String s) {
		int spacesLeft = length - lengthCount;
		if(s.length() <= spacesLeft) {
			for(int i = 0; i < s.length(); i++) {
				matrix[widthCount][lengthCount] = s.charAt(i);
				lengthCount++;
			}
			if(lengthCount == (length -1)) {
				lengthCount = 0;
				if(widthCount == (width -1)) {
					full = true;
				} else {
					widthCount++;
				}
			}
			return 1;
		} else {
			if(widthCount < width - 1) {
				widthCount++;
				lengthCount = 0;
				return addString(s);
			} else {
				full = true;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return "LabelPaper [matrix=" + Arrays.toString(matrix) + ", length=" + length + ", width=" + width
				+ ", lengthCount=" + lengthCount + ", widthCount=" + widthCount + ", full=" + full + "]";
	}

}
