package com.mazechallange;

import com.mazechallange.model.Cell;
import com.mazechallange.model.DirectionEnum;

public class Path {

	private Cell startCell;
	private DirectionEnum direction;

	public Path(Cell startCell, DirectionEnum direction) {
		this.startCell = startCell;
		this.direction = direction;
	}

	public Cell getStartCell() {
		return startCell;
	}

	public DirectionEnum getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return "Path [startCell=" + startCell + ", direction=" + direction + "]";
	}
}
