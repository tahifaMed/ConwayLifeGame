package org.conway.demo;

import javafx.application.Application;

public class Demo {
	
	public void Iteration1Demo(String[] args){
		Application.launch(org.conway.iteration1.Iteration1Demo.class, args);
	}
	
	public void Iteration2Demo(String[] args){
		Application.launch(org.conway.iteration2.Iteration2Demo.class, args);
	}
	
	public void Iteration3Demo(String[] args){
		Application.launch(org.conway.iteration3.Iteration3Demo.class, args);
	}
	
	public void Iteration4Demo(String[] args){
		Application.launch(org.conway.iteration4.Iteration4Demo.class, args);
	}
	
	public void Iteration5Demo(String[] args){
		Application.launch(org.conway.iteration5.Iteration5Demo.class, args);
	}
	
	public static void main(String[] args) {
//		new Demo().Iteration1Demo(args);
//		new Demo().Iteration2Demo(args);
//		new Demo().Iteration3Demo(args);
//		new Demo().Iteration4Demo(args);
		new Demo().Iteration5Demo(args);
	}

}
