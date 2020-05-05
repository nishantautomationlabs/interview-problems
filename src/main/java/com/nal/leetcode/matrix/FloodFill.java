package com.nal.leetcode.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 05/02/20.
 * 733. Flood Fill
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * At the end, return the modified image.
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 */
public class FloodFill {

    public int[][] floodFillIterative(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0)
            return image;
        int currColor = image[sr][sc];
        if (currColor == newColor)
            return image;

        int rowCount = image.length;
        int colCount = image[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            image[p.x][p.y] = newColor;

            for (int[] dir : dirs) {
                int r = p.x + dir[0];
                int c = p.y + dir[1];
                if (r < 0 || r >= rowCount || c < 0 || c >= colCount || image[r][c] != currColor)
                    continue;
                queue.add(new Pair(r, c));
            }
        }
        return image;
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public int[][] floodFillRecursive(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0)
            return image;

        int currColor = image[sr][sc];
        if (currColor == newColor)
            return image;
        floodFill(image, sr, sc, currColor, newColor);
        return image;
    }

    private void floodFill(int[][] image, int row, int col, int currColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != currColor) {
            return;
        }
        image[row][col] = newColor;
        floodFill(image, row - 1, col, currColor, newColor);
        floodFill(image, row + 1, col, currColor, newColor);
        floodFill(image, row, col - 1, currColor, newColor);
        floodFill(image, row, col + 1, currColor, newColor);
    }
}
