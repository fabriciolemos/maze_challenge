package com.mazechallange;

import java.util.ArrayDeque;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import com.mazechallange.model.Cell;
import com.mazechallange.model.DirectionEnum;
import com.mazechallange.model.Maze;
import com.mazechallange.model.RouteSituationEnum;

// Challenge: http://www.epdeveloperchallenge.com/
public class MazeSolver {

	@Inject private Maze maze;
	private Cell currentCell;
	private ArrayDeque<Path> possiblePaths;
	private int moves;

	public String solveMaze(@Observes ContainerInitialized event, @Parameters List<String> parameters) {

		initMaze();
		String note = findMazeSolution();
		System.out.println(note);
		System.out.println("moves:" + moves);
		return note;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}

	private void initMaze() {
		currentCell = maze.getCurrentCell();
		possiblePaths = new ArrayDeque<>();
	}

	private String findMazeSolution() {
		while (!currentCell.isAtMazeEnd()) {
			findPossiblePaths();
			Path nextPath = possiblePaths.removeFirst();
			followPath(nextPath);
		}
		return maze.getNote();
	}

	private void findPossiblePaths() {
		for (DirectionEnum direction : DirectionEnum.values()) {
			if (isDirectionUnexplored(direction)) {
				possiblePaths.addFirst(new Path(currentCell, direction));
			}
		}
	}

	private void followPath(Path path) {
		goToPathStart(path.getStartCell());
		System.out.println("Moving to: " + path);
		maze.moveTo(path.getDirection());
		moves++;
		currentCell = maze.getCurrentCell();
	}

	private void goToPathStart(Cell nextCell) {
		if (!nextCell.equals(currentCell)) {
			maze.moveTo(nextCell);
			moves++;
		}
	}

	private boolean isDirectionUnexplored(DirectionEnum direction) {
		return maze.getRouteSituation(direction).equals(RouteSituationEnum.UNEXPLORED);
	}
}
