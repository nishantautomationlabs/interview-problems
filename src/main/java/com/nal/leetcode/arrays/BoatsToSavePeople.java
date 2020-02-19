package com.nal.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by nishant on 10/02/20.
 * 881. Boats to Save People
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
 * Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
 * Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)
 */
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0 || limit == 0)
            return 0;

        Arrays.sort(people);
        int left = 0, right = people.length - 1, res = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit)
                left++;
            right--;
            res++;
        }
        return res;
    }
}
