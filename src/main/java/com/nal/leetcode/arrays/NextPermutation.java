package com.nal.leetcode.arrays;

/**
 * Created by nishant on 05/02/20.
 * 31. Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation permutation = new NextPermutation();
        int nums[] = {5,1,1};
        permutation.nextPermutation(nums);
    }

//    [6, 2, 1, 5, 4, 3, 0]  -- from 5 is the longest decreasing subsequence
//    [6, 2, 3, 5, 4, 1, 0]  -- take the number before 5 - 1 and swap it with number greater than that 3
//    [6, 2, 3, 0, 1, 4, 5]  -- reverse the numbers starting from 5

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        int indexOfFirstNumber = nums.length - 2;
        while (indexOfFirstNumber >= 0 && nums[indexOfFirstNumber] >= nums[indexOfFirstNumber + 1])
            indexOfFirstNumber--;
        if (indexOfFirstNumber == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int indexOfSecondNumber;
        for (indexOfSecondNumber = nums.length - 1; indexOfSecondNumber > indexOfFirstNumber; indexOfSecondNumber--) {
            if (nums[indexOfSecondNumber] > nums[indexOfFirstNumber]) {
                swap(nums, indexOfFirstNumber, indexOfSecondNumber);
                break;
            }
        }
        reverse(nums, indexOfFirstNumber + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
