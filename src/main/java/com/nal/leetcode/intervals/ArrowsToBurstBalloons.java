package com.nal.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by nishant on 27/02/20.
 * 452. Minimum Number of Arrows to Burst Balloons
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input
 * is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't
 * matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end.
 * There will be at most 104 balloons.
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and
 * xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be
 * shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows
 * that must be shot to burst all balloons.
 * Example:
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * Output:
 * 2
 */
public class ArrowsToBurstBalloons {

    public static void main(String[] args) {
        int[][] input = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        ArrowsToBurstBalloons sol = new ArrowsToBurstBalloons();
        sol.findMinArrowShots(input);
    }

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0)
            return 0;

        int result = 1;
        Arrays.sort(points, Comparator.comparingInt(s -> s[0]));
        for (int i = 1; i < points.length; i++) {
            if (overlaps(points[i], points[i - 1])) {
                points[i][0] = Math.max(points[i][0], points[i - 1][0]);
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            } else {
                result++;
            }
        }
        return result;
    }

    private boolean overlaps(int[] a, int[] b) {
        if (a[0] <= b[1] && b[0] <= a[1])
            return true;
        return false;
    }
}
