package org.conway.iteration4;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

import org.conway.gui.GUIInterface;
import org.conway.service.ConwayAlgorithm;

public class Iteration4Demo extends Application {

	@Override
	public void start(final Stage primaryStage) throws IOException {
		
		ConwayAlgorithm conwayAlgorithm = new ConwayAlgorithm("resources/iteration4/matrix.txt");
		GUIInterface guiInterface = new GUIInterface();
		guiInterface.start(primaryStage, conwayAlgorithm);
	}

}