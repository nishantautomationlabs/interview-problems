package com.nal.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by nishant on 01/02/20.
 */
public class KthLargest {

    //Time Complexity: O(NlogN)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //Time Complexity: O(NlogK)
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        KthLargest kthLargest = new KthLargest();
        System.out.println(kthLargest.findKthLargest3(nums, 4));

    }

    //Time Complexity: O(N)
    public int findKthLargest3(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return -1;

        int left = 0, right = nums.length - 1;
        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == k - 1)
                return nums[pivotIndex];
            else if (pivotIndex < k - 1)
                left = pivotIndex + 1;
            else
                right = pivotIndex - 1;
        }
    }

    private int partition(int[] nums, int left, int right) {
        int end = right;
        int pivotVal = nums[right];
        right--;
        while (left <= right) {
            if (nums[left] < pivotVal && nums[right] > pivotVal)
                swap(nums, left++, right--);
            else if (nums[right] <= pivotVal)
                right--;
            else if (nums[left] >= pivotVal)
                left++;
        }
        swap(nums, left, end);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
