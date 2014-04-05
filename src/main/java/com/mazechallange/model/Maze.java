package com.mazechallange.model;

import javax.inject.Inject;

import com.mazechallange.webservice.CurrentCellVO;
import com.mazechallange.webservice.MazeWSClient;

public class Maze {

	private CurrentCellVO cellVO;
	private MazeWSClient mazeWSClient;
	private String mazeId;

	@Inject
	public Maze(MazeWSClient mazeWSClient) {
		this.mazeWSClient = mazeWSClient;
		cellVO = mazeWSClient.init();
		mazeId = cellVO.getMazeGuid();
	}

	public Cell getCurrentCell() {
		return new Cell(cellVO.getX(), cellVO.getY(), cellVO.isAtEnd());
	}

	public RouteSituationEnum getRouteSituation(DirectionEnum routeTo) {

		switch (routeTo) {
		case NORTH:
			return RouteSituationEnum.valueOf(cellVO.getNorth());
		case SOUTH:
			return RouteSituationEnum.valueOf(cellVO.getSouth());
		case WEST:
			return RouteSituationEnum.valueOf(cellVO.getWest());
		case EAST:
			return RouteSituationEnum.valueOf(cellVO.getEast());
		default:
			throw new RuntimeException(routeTo + "not mapped");
		}
	}

	public void moveTo(Cell nextCell) {
		mazeWSClient.jump(mazeId, nextCell.getHorizontalCoordinate(), nextCell.getVerticalCoordinate());
		cellVO = mazeWSClient.currentCell(mazeId);
	}

	public void moveTo(DirectionEnum direction) {
		mazeWSClient.move(mazeId, direction.toString());
		cellVO = mazeWSClient.currentCell(mazeId);
	}

	public String getNote() {
		return cellVO.getNote();
	}
}