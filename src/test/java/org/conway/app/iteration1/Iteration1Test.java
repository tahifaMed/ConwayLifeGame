package org.conway.app.iteration1;

import java.io.IOException;

import org.conway.service.ConwayAlgorithm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class Iteration1Test {
	
	
	private ConwayAlgorithm conwayAlgorithm;
	private ConwayAlgorithm ConwayAlgorithmDataTest;
	private ConwayAlgorithm ConwayAlgorithmEvolution1;
	
	@Before
	public void setUp() throws IOException{
		conwayAlgorithm = new ConwayAlgorithm("resources/iteration1/matrix.txt");
		ConwayAlgorithmDataTest = new ConwayAlgorithm("resources/iteration1/DataTest.txt");
		ConwayAlgorithmEvolution1 = new ConwayAlgorithm("resources/iteration1/dataEvolution1.txt");
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
		int neighbors = conwayAlgorithm.calculateNeighbor(5, 7);
		Assert.assertEquals(3, neighbors);
	}
	
	@Test
	public void isConwayFirstEvolutionCorrect(){
		conwayAlgorithm.applyConwayAlgorithm();
		Assert.assertEquals(ConwayAlgorithmEvolution1.getMatrix(), conwayAlgorithm.getMatrix());
	}

}
