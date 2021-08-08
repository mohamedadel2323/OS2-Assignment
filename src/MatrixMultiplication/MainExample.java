/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrixMultiplication;

import java.util.Date;

/**
 *
 * @author AbdallaEssam
 */
public class MainExample {

    public static void main(String[] args) {
        double matrix1[][] = MatrixGenerator.generate(1000, 1000);
        double matrix2[][] = MatrixGenerator.generate(1000, 1000);
        double result[][] = new double[matrix1.length][matrix2[0].length];
        Date start = new Date();
        Multiplier.multiply(matrix1, matrix2, result);
        Date end = new Date();        

        System.out.printf("Individual Parallel: %d%n", end.getTime() - start.getTime());
    }
}
