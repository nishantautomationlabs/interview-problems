package com.nal.leetcode;

/**
 * Created by nishant on 02/02/20.
 */
public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null)
            return true;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[i].length; j++)
            {
                if(matrix[i][j] != matrix[i-1][j-1])
                    return false;
            }
        }
        return true;
    }
}
