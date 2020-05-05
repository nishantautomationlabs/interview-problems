package com.nal.leetcode.matrix;

/**
 * Created by nishant on 04/02/20.
 * 48. Rotate Image
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * Example 1:
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
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
