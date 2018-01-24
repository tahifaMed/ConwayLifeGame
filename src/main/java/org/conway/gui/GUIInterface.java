package org.conway.gui;

import java.io.File;
import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import org.conway.domain.Matrix;
import org.conway.service.ConwayAlgorithm;

public class GUIInterface {

	
	public void start(final Stage primaryStage, ConwayAlgorithm conwayAlgorithm) throws IOException {
		
		primaryStage.setTitle("Conway game of Life");
		primaryStage.show();
		
		final Scene scene = new Scene(constructGridPane(conwayAlgorithm.getMatrix()));
		File f = new File("css/style.css");
		scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		
		new AnimationTimer() {
			Integer evolution = 1;
            @Override public void handle(long currentNanoTime) {
                
            	conwayAlgorithm.applyConwayAlgorithm();
    			scene.setRoot(constructGridPane(conwayAlgorithm.getMatrix()));
    			primaryStage.sizeToScene();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                	e.printStackTrace();
                }
                if(conwayAlgorithm.getMatrix().getNumberOfEvolution() == evolution)
                	this.stop();
                else 
                	evolution=evolution+1;
            }
        }.start();
		
	}

	public GridPane constructGridPane(Matrix matrix){
		GridPane root = new GridPane();

		for (int x = 0; x < matrix.getRowSize(); x++) {
			for (int y = 0; y < matrix.getColumnSize(); y++) {

				// Create a new TextField in each Iteration
				TextField tf = new TextField();
				tf.setPrefHeight(20);
				tf.setPrefWidth(20);
				tf.setAlignment(Pos.CENTER);
				tf.setEditable(false);
				
				if (matrix.getConwayMatrix()[x][y] == 1){
					tf.getStyleClass().add("black");
				}
				else{
					tf.getStyleClass().add("white");
				}
				root.setRowIndex(tf, x);
				root.setColumnIndex(tf, y);
				root.getChildren().add(tf);
			}
		}
		return root;
	}
}