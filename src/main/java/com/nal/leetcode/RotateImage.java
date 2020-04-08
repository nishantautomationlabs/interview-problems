package com.nal.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by nishant on 04/02/20.
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

//        Collections.reverse(Arrays.asList(matrix));
        matrix = reverseMatrix(matrix);

        int rows = matrix.length;
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private int[][] reverseMatrix(int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            int[] temp = matrix[start];
            matrix[start++] = matrix[end];
            matrix[end--] = temp;
        }
        return matrix;
    }
}
