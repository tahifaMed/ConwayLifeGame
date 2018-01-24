package org.conway.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.conway.domain.Matrix;

public class ReadMatrix {
	
	private BufferedReader buffer;

    public Matrix readFile(String filename) throws IOException {

    	
    	buffer = new BufferedReader(new FileReader(filename));
        
        String line;
        int row = 0;
        Integer dimension = Integer.parseInt(buffer.readLine());
        Integer numberOfEvolution = Integer.parseInt(buffer.readLine());
        Matrix matrix = new Matrix(dimension, numberOfEvolution);
        while ((line = buffer.readLine()) != null) {
            String[] vals = line.trim().split("\\s+");
            for (int col = 0; col < dimension; col++) {
                matrix.getConwayMatrix()[row][col] = Integer.parseInt(vals[col]);
            }

            row++;
        }     
        return matrix;
    }

}


