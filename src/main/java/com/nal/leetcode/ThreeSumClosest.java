package com.nal.leetcode;

import java.util.Arrays;

/**
 * Created by nishant on 31/01/20.
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return 0;

        Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2];
        for(int i = 0; i < nums.length; i++)
        {
            int left = i+1;
            int right = nums.length-1;
            while(left < right)
            {
                int sum = nums[i]+nums[left]+nums[right];

                if(Math.abs(target - sum) < Math.abs(target - closest))
                    closest = sum;
                if(sum  ==  target)
                    return sum;
                else if(sum > target)
                    right--;
                else
                    left++;
            }
        }
        return closest;
    }
}
