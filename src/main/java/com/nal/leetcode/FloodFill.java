package com.nal.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 05/02/20.
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
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if ((p.x >= 0 && p.x < rowCount && p.y >= 0 && p.y < colCount && image[p.x][p.y] == currColor)) {
                image[p.x][p.y] = newColor;
                queue.add(new Pair(p.x - 1, p.y));
                queue.add(new Pair(p.x + 1, p.y));
                queue.add(new Pair(p.x, p.y - 1));
                queue.add(new Pair(p.x, p.y + 1));
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
        int rowCount = image.length;
        int colCount = image[0].length;
        floodFill(image, rowCount, colCount, sr, sc, currColor, newColor);
        return image;
    }

    private void floodFill(int[][] image, int rowCount, int colCount, int row, int col, int currColor, int newColor) {
        if (row >= 0 && row < rowCount && col >= 0 && col < colCount && image[row][col] == currColor) {
            image[row][col] = newColor;
            floodFill(image, rowCount, colCount, row - 1, col, currColor, newColor);
            floodFill(image, rowCount, colCount, row + 1, col, currColor, newColor);
            floodFill(image, rowCount, colCount, row, col - 1, currColor, newColor);
            floodFill(image, rowCount, colCount, row, col + 1, currColor, newColor);
        }

    }
}
