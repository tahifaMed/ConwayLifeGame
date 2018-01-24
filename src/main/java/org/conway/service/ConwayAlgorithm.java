package org.conway.service;

import java.io.IOException;

import org.conway.domain.Matrix;

public class ConwayAlgorithm {

	private Matrix matrix;
	
	public ConwayAlgorithm(String filename) throws IOException {
		matrix = new ReadMatrix().readFile(filename);
	}

	public void applyConwayAlgorithm() {
		Integer[][] tempMatrix = new Integer[matrix.getRowSize()][matrix.getColumnSize()];
		for (int x = 0; x < matrix.getConwayMatrix().length; x++) {
			for (int y = 0; y < matrix.getConwayMatrix()[x].length; y++) {
				Integer neighbors = calculateNeighbor(x, y);
				if (matrix.getConwayMatrix()[x][y] == 1
						&& (neighbors >= 4 || neighbors == 0 || neighbors == 1)) {
					tempMatrix[x][y] = 0;
				}
				else if (matrix.getConwayMatrix()[x][y] == 0 && (neighbors == 3)) {
					tempMatrix[x][y] = 1;
				}
				else{
					tempMatrix[x][y] = matrix.getConwayMatrix()[x][y];
				}
			}
		}
		copyConwayMatrix(tempMatrix);
	}

	public void showMatrix(Integer[][] matrix) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				System.out.print(" " + matrix[x][y] + " ");
			}
			System.out.println();
		}
	}
	
	public void copyConwayMatrix(Integer[][] tempMatrix) {
		for (int x = 0; x < tempMatrix.length; x++) {
			for (int y = 0; y < tempMatrix[x].length; y++) {
				matrix.getConwayMatrix()[x][y]= tempMatrix[x][y];
			}
		}
	}

	public int calculateNeighbor(Integer x, Integer y) {
		int count = 0;
		if (x - 1 >= 0 && matrix.getConwayMatrix()[x - 1][y] == 1) {
			count++;
		}
		if (x - 1 >= 0 && y + 1 < matrix.getColumnSize() && matrix.getConwayMatrix()[x - 1][y + 1] == 1) {
			count++;
		}
		if (y + 1 < matrix.getColumnSize() && matrix.getConwayMatrix()[x][y + 1] == 1) {
			count++;
		}
		if (x + 1 < matrix.getRowSize() && y + 1 < matrix.getColumnSize()
				&& matrix.getConwayMatrix()[x + 1][y + 1] == 1) {
			count++;
		}
		if (x + 1 < matrix.getRowSize() && matrix.getConwayMatrix()[x + 1][y] == 1) {
			count++;
		}
		if (x + 1 < matrix.getRowSize() && y - 1 >= 0 && matrix.getConwayMatrix()[x + 1][y - 1] == 1) {
			count++;
		}
		if (y - 1 >= 0 && matrix.getConwayMatrix()[x][y - 1] == 1) {
			count++;
		}
		if (x - 1 >= 0 && y - 1 >= 0 && matrix.getConwayMatrix()[x - 1][y - 1] == 1) {
			count++;
		}

		return count;
	}

	public Matrix getMatrix() {
		return matrix;
	}

	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}

	

}
