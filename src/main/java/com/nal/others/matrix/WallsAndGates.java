package com.nal.others.matrix;

/**
 * Created by nishant on 10/02/20.
 * 663. Walls and Gates (LintCode)
 * You are given a m x n 2D grid initialized with these three possible values.
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a Gate, that room should remain filled with INF
 * Input:
 * [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 * Output:
 * [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 */
public class WallsAndGates {
    public static void main(String[] args) {
        WallsAndGates solution = new WallsAndGates();
        int[][] input =  {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        solution.wallsAndGates(input);
        System.out.println(input);
    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;
        int rows = rooms.length, cols = rooms[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0)
                    explore(rooms, 0, i, j);
            }
        }
    }

    private void explore(int[][] rooms, int dist, int i, int j) {
        int rows = rooms.length, cols = rooms[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols || rooms[i][j] < dist)
            return;
        rooms[i][j] = dist;
        explore(rooms, dist + 1, i - 1, j);
        explore(rooms, dist + 1, i + 1, j);
        explore(rooms, dist + 1, i, j - 1);
        explore(rooms, dist + 1, i, j + 1);
    }
}
