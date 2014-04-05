package com.mazechallange.webservice;

import javax.xml.bind.annotation.XmlRootElement;

// Sample json:
// {"currentCell":{"note":"","mazeGuid":"927ee80e-c19d-4e03-a1e7-4277fd109d66","atEnd":false,"north":"VISITED","east":"UNEXPLORED","west":"BLOCKED",
// "south":"BLOCKED","x":0,"y":1,"previouslyVisited":false}}
@XmlRootElement(name = "currentCell")
public class CurrentCellVO {

	private String note;
	private String mazeGuid;
	private boolean atEnd;
	private String north;
	private String east;
	private String west;
	private String south;
	private int x;
	private int y;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getMazeGuid() {
		return mazeGuid;
	}

	public void setMazeGuid(String mazeGuid) {
		this.mazeGuid = mazeGuid;
	}

	public boolean isAtEnd() {
		return atEnd;
	}

	public void setAtEnd(boolean atEnd) {
		this.atEnd = atEnd;
	}

	public String getNorth() {
		return north;
	}

	public void setNorth(String north) {
		this.north = north;
	}

	public String getEast() {
		return east;
	}

	public void setEast(String east) {
		this.east = east;
	}

	public String getWest() {
		return west;
	}

	public void setWest(String west) {
		this.west = west;
	}

	public String getSouth() {
		return south;
	}

	public void setSouth(String south) {
		this.south = south;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Cell [note=" + note + ", mazeGuid=" + mazeGuid + ", atEnd=" + atEnd + ", north=" + north + ", east=" + east + ", west=" + west
				+ ", south=" + south + ", x=" + x + ", y=" + y + "]";
	}
}
