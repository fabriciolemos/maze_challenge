package com.mazechallange.model;

import org.junit.Before;
import org.junit.Test;

import com.mazechallange.webservice.WSClientProducer;

import static org.junit.Assert.assertNotNull;

public class TestMaze {
	// This class only tests if a communication with the maze web-service was stablished. Since we have no control about the maze configuration initiated, there is not much we
	// can validate.
	// TODO: Mock ws-client so more things can be validated.

	private Maze maze;

	@Before
	public void configureMock() throws Exception {
		maze = new Maze(new WSClientProducer().getMazeWebServiceClient());
	}

	@Test
	public void currentCellNotNull() {
		assertNotNull(maze.getCurrentCell());
	}

	// TODO: this will be used by the mock. See TODO above.
	// private CurrentCellVO currentCellVOFactoryMethod() throws Exception {
	// return (CurrentCellVO) JAXBContext
	// .newInstance(CurrentCellVO.class)
	// .createUnmarshaller()
	// .unmarshal(
	// new MappedXMLStreamReader(new JSONObject(FileUtils.readFileToString(new File("src/test/resources/currentCell.json"))),
	// new MappedNamespaceConvention(new Configuration())));
	// }
}
