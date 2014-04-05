package com.mazechallange.model;

public class Cell {

	private int horizontalCoordinate;
	private int verticalCoordinate;
	private boolean atMazeEnd;

	public Cell(int horizontalCoordinate, int verticalCoordinate, boolean atMazeEnd) {
		this.horizontalCoordinate = horizontalCoordinate;
		this.verticalCoordinate = verticalCoordinate;
		this.atMazeEnd = atMazeEnd;
	}

	public int getHorizontalCoordinate() {
		return horizontalCoordinate;
	}

	public int getVerticalCoordinate() {
		return verticalCoordinate;
	}

	public boolean isAtMazeEnd() {
		return atMazeEnd;
	}

	@Override
	public String toString() {
		return "Cell [horizontalCoordinate=" + horizontalCoordinate + ", verticalCoordinate=" + verticalCoordinate + ", atMazeEnd=" + atMazeEnd + "]";
	}
}