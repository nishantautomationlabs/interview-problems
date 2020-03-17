package com.nal.leetcode.arrays;

/**
 * Created by nishant on 16/03/20.
 * 1184. Distance Between Bus Stops
 * A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.
 * The bus goes along both directions i.e. clockwise and counterclockwise.
 * Return the shortest distance between the given start and destination stops.
 * Example 1:
 * Input: distance = [1,2,3,4], start = 0, destination = 1
 * Output: 1
 * Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 */
public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance == null || distance.length == 0)
            return 0;

        int totalSum = 0;
        int clockwiseSum = 0;
        for (int i = 0; i < distance.length; i++) {
            if (start < destination && (i >= start && i < destination)) {
                clockwiseSum += distance[i];
            }
            if (start > destination && (i >= start || i < destination)) {
                clockwiseSum += distance[i];
            }
            totalSum += distance[i];
        }

        return Math.min(clockwiseSum, totalSum - clockwiseSum);
    }
}
