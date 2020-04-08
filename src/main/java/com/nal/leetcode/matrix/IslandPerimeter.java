 package com.nal.leetcode.matrix;

/**
 * Created by nishant on 10/02/20.
 * 463. Island Perimeter
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * Input:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * Output: 16
 */
public class IslandPerimeter {

    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    result += perimeter(grid, i, j);
            }
        }
        return result;
    }

    public int perimeter(int[][] grid, int i, int j) {
        int per = 0;
        for (int[] dir : DIRS) {
            int r = i + dir[0], c = j + dir[1];
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0)
                per++;
        }
        return per;
    }
}
