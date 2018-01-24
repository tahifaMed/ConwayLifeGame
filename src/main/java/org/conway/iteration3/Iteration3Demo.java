package org.conway.iteration3;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

import org.conway.gui.GUIInterface;
import org.conway.service.ConwayAlgorithm;

public class Iteration3Demo extends Application {

	@Override
	public void start(final Stage primaryStage) throws IOException {
		
		ConwayAlgorithm conwayAlgorithm = new ConwayAlgorithm("resources/iteration3/matrix.txt");
		GUIInterface guiInterface = new GUIInterface();
		guiInterface.start(primaryStage, conwayAlgorithm);
	}

}