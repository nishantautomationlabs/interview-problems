package com.nal.leetcode.string;

/**
 * Created by nishant on 10/02/20.
 * 657. Robot Return to Origin
 * There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
 * The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.
 */
public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0)
            return false;

        int xAxis = 0, yAxis = 0;
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'U':
                    yAxis++;
                    break;
                case 'D':
                    yAxis--;
                    break;
                case 'L':
                    xAxis++;
                    break;
                case 'R':
                    xAxis--;
                    break;
            }
        }
        return xAxis == 0 && yAxis == 0;
    }
}
