package com.nal.leetcode.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by nishant on 01/02/20.
 * 215. Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 */
public class KthLargest {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        KthLargest kthLargest = new KthLargest();
        System.out.println(kthLargest.findKthLargest3(nums, 4));
    }

    //Time Complexity: O(NlogN)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
//        use return arr[k - 1]; for kth smallest
        return nums[nums.length - k];
    }

    private int kthLargestUsingSort(Integer[] arr, int k) {
        //need Integer[] array instead of int[] as it takes T type object
        Arrays.sort(arr, Collections.reverseOrder());
        return arr[k - 1];
    }

    //Time Complexity: O(NlogK)
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.isEmpty() || nums[i] > minHeap.peek()) {
                minHeap.add(nums[i]);
                if (minHeap.size() > k)
                    minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    //Time Complexity: O(N)
    public int findKthLargest3(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return -1;

        int left = 0, right = nums.length - 1;
        int pivotIndex = 0;
        while (pivotIndex != k - 1) {
            pivotIndex = partition(nums, left, right);
            if (pivotIndex == k - 1) {
                return nums[pivotIndex];
            }
            if (pivotIndex < k - 1) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int j = left;
        for (int i = left; i <= right - 1; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, j++);
            }
        }
        swap(nums, j, right);
        return j;
    }

    private int randomPartition(int[] arr, int start, int end) {
        int n = end - start + 1;
        int randomPivot = (int) (Math.random() * n);
        swap(arr, start + randomPivot, end);
        return partition(arr, start, end);

    }

    private int partition2(int[] nums, int left, int right) {
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
