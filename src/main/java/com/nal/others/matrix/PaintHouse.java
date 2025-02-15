package com.nal.others.matrix;

/**
 * Created by nishant on 07/02/20.
 * 515. Paint House (LintCode)
 * Greedy Algorithm
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * input = {{14, 2, 11},
 *          {11, 14, 5},
 *          {14, 3, 10}};
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0)
            return -1;

        int rows = costs.length;
        for (int i = 1; i < rows; i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(Math.min(costs[rows-1][0],costs[rows-1][1]), costs[rows-1][2]);
    }

    public static void main(String[] args) {
        int[][] input = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
        PaintHouse paintHouse = new PaintHouse();
        int minCost = paintHouse.minCost(input);
        System.out.println("Min Cost is: " + minCost);
    }

}
