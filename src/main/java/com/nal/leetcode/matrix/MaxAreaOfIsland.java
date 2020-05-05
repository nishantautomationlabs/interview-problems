package com.nal.leetcode.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 09/02/20.
 * 695. Max Area of Island
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */
public class MaxAreaOfIsland {

    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int maxAreaOfIslandIterative(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length, cols = grid[0].length;

        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0)
                    continue;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                grid[i][j] = 0;
                int area = 0;
                while (!q.isEmpty()) {
                    int[] p = q.poll();
                    area++;
                    for (int[] dir : DIRS) {
                        int r = p[0] + dir[0];
                        int c = p[1] + dir[1];
                        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0)
                            continue;
                        grid[r][c] = 0;
                        q.offer(new int[]{r, c});
                    }
                }
                res = Math.max(res, area);
            }
        }
        return res;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    res = Math.max(res, calcArea(grid, i, j));
            }
        }
        return res;
    }

    private int calcArea(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return 0;
        grid[i][j] = 0;
        return 1 +
                calcArea(grid, i - 1, j) +
                calcArea(grid, i + 1, j) +
                calcArea(grid, i, j - 1) +
                calcArea(grid, i, j + 1);
    }
}
