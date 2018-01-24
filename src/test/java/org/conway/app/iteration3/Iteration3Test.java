package org.conway.app.iteration3;

import java.io.IOException;

import org.conway.service.ConwayAlgorithm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class Iteration3Test {
	
	
	private ConwayAlgorithm conwayAlgorithm;
	private ConwayAlgorithm ConwayAlgorithmDataTest;
	private ConwayAlgorithm ConwayAlgorithmEvolution1;
	
	@Before
	public void setUp() throws IOException{
		conwayAlgorithm = new ConwayAlgorithm("resources/iteration3/matrix.txt");
		ConwayAlgorithmDataTest = new ConwayAlgorithm("resources/iteration3/DataTest.txt");
		ConwayAlgorithmEvolution1 = new ConwayAlgorithm("resources/iteration3/dataEvolution1.txt");
	}
	
	@Test
	public void isMatrixLoaded(){
		Assert.assertNotNull(conwayAlgorithm.getMatrix());
	}
	
	@Test
	public void isDataCorrectlyLoaded(){
		Assert.assertEquals(ConwayAlgorithmDataTest.getMatrix(), conwayAlgorithm.getMatrix());
	}
	@Test
	public void isNumberOfNeighborsCorrect(){
		int neighbors = conwayAlgorithm.calculateNeighbor(10, 5);
		Assert.assertEquals(3, neighbors);
	}
	
	@Test
	public void isConwayFirstEvolutionCorrect(){
		conwayAlgorithm.applyConwayAlgorithm();
		Assert.assertEquals(ConwayAlgorithmEvolution1.getMatrix(), conwayAlgorithm.getMatrix());
	}

}
