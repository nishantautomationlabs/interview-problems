package com.nal.leetcode.arrays;

/**
 * Created by nishant on 14/03/20.
 * 985. Sum of Even Numbers After Queries
 * We have an array A of integers, and an array queries of queries.
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 * Example 1:
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 */
public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        if(A == null || A.length == 0 || queries == null || queries.length == 0)
            return null;

        int[] result = new int[queries.length];
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0)
                sum += A[i];
        }

        for(int i = 0; i < queries.length; i++) {
            int index = queries[i][1];
            int val = queries[i][0];
            if(A[index] % 2 == 0) { //if the number initially was even, remove it from sum
                sum -= A[index];
            }
            A[index] = A[index] + val;
            //if the new number is even add it to sum
            if(A[index] % 2 == 0) {
                sum += A[index];
            }
            result[i] = sum;
        }
        return result;
    }
}
