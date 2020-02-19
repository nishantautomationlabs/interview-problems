package com.nal.leetcode;

/**
 * Created by nishant on 05/02/20.
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation permutation = new NextPermutation();
        int nums[] = {5,1,1};
        permutation.nextPermutation(nums);
    }

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
