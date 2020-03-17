package com.nal.leetcode.matrix;

/**
 * Created by nishant on 15/03/20.
 * 807. Max Increase to Keep City Skyline
 * In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well.
 * At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.
 * What is the maximum total sum that the height of the buildings can be increased?
 * Example:
 * Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * Output: 35
 */
public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int[] maxInRow = new int[rows];
        int[] maxInCol = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxInRow[i] = Math.max(maxInRow[i], grid[i][j]);
                maxInCol[j] = Math.max(maxInCol[j], grid[i][j]);
            }
        }
        int maxSum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int maxAllowedVal = Math.min(maxInRow[i], maxInCol[j]);
                maxSum += maxAllowedVal - grid[i][j];
            }
        }
        return maxSum;
    }
}
