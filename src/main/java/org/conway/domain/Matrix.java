package org.conway.domain;


public class Matrix {

	private Integer[][] conwayMatrix;
	private Integer columnSize;
	private Integer rowSize;
	private Integer numberOfEvolution;

	public Matrix(Integer dimension, Integer numberOfEvolution) {
		this.numberOfEvolution = numberOfEvolution;
		this.columnSize = dimension;
		this.rowSize = dimension;
		this.conwayMatrix = new Integer[dimension][dimension];
	}

	public Integer[][] getConwayMatrix() {
		return conwayMatrix;
	}

	public void setConwayMatrix(Integer[][] conwayMatrix) {
		this.conwayMatrix = conwayMatrix;
	}

	public Integer getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(Integer columnSize) {
		this.columnSize = columnSize;
	}

	public Integer getRowSize() {
		return rowSize;
	}

	public void setRowSize(Integer rowSize) {
		this.rowSize = rowSize;
	}

	public Integer getNumberOfEvolution() {
		return numberOfEvolution;
	}

	public void setNumberOfEvolution(Integer numberOfEvolution) {
		this.numberOfEvolution = numberOfEvolution;
	}

	public boolean compareMatrix(Integer[][] matrix1, Integer[][] matrix2) {
		if (matrix1.length != matrix2.length)
			return false;
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2.length; j++) {
				if (matrix1[i][j] != matrix2[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		Matrix matrix = (Matrix) obj;
		if(this.columnSize != matrix.columnSize || 
				this.rowSize != matrix.rowSize || 
				this.numberOfEvolution != matrix.numberOfEvolution || 
				!compareMatrix(this.conwayMatrix, matrix.conwayMatrix))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matrix [conwayMatrix=" + showMatrix(conwayMatrix)
				+ ", columnSize=" + columnSize + ", rowSize=" + rowSize
				+ ", numberOfEvolution=" + numberOfEvolution + "]";
	}
	
	public StringBuffer showMatrix(Integer[][] matrix) {
		StringBuffer buffer = new StringBuffer();
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				buffer.append(" " + matrix[x][y] + " ");
			}
			buffer.append("\n");
		}
		return buffer;
	}

}
