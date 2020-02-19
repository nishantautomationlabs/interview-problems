package com.nal.leetcode.matrix;

/**
 * Created by nishant on 09/02/20.
 * 200. Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    markIsland(grid, i, j, visited);
                }
            }
        }
        return res;
    }

    private void markIsland(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || visited[i][j] || grid[i][j] == '0')
            return;
        visited[i][j] = true;
        markIsland(grid, i - 1, j, visited);
        markIsland(grid, i + 1, j, visited);
        markIsland(grid, i, j - 1, visited);
        markIsland(grid, i, j + 1, visited);
    }
}
