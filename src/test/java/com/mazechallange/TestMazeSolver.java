package com.mazechallange;

import org.junit.Before;

import com.mazechallange.model.Maze;
import com.mazechallange.webservice.WSClientProducer;

import static org.junit.Assert.assertNotNull;

public class TestMazeSolver {

	private MazeSolver mazeSolver;

	@Before
	public void initMaze() {
		mazeSolver = new MazeSolver();
		mazeSolver.setMaze(new Maze(new WSClientProducer().getMazeWebServiceClient()));
	}

	// This is commented out, since it finds the real solution for the maze and requires a considerable amount of time.
	// @Test
	public void findSolution() {
		assertNotNull(mazeSolver.solveMaze(null, null));
	}
}