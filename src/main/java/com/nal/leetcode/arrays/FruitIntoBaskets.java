package com.nal.leetcode.arrays;

/**
 * Created by nishant on 16/02/20.
 * 904. Fruit Into Baskets
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 * You start at any tree of your choice, then repeatedly perform the following steps:
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 * What is the total amount of fruit you can collect with this procedure?
 * Example 1:
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 */
public class FruitIntoBaskets {

    public int totalFruit2(int[] tree) {
        if(tree == null || tree.length == 0) {
            return 0;
        }
        int left = 0;
        int lastFruit = -1;
        int lastFruitIndex = -1;
        int secondLastFruit = -1;
        int secondLastFruitIndex = -1;
        int maxFruit = 0;
        for(int right = 0; right < tree.length; right++) {
            if(lastFruit == -1) {
                lastFruit = tree[right];
                lastFruitIndex = right;
            }
            if(tree[right] != lastFruit && tree[right] != secondLastFruit) {
                left = secondLastFruitIndex + 1;
            }
            if(tree[right] == lastFruit) {
                lastFruitIndex = right;
            }
            else {
                secondLastFruit = lastFruit;
                secondLastFruitIndex = lastFruitIndex;
                lastFruit = tree[right];
                lastFruitIndex = right;
            }
            maxFruit = Math.max(maxFruit, right - left + 1);

        }
        return maxFruit;
    }

    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0)
            return 0;
        int lastType = -1;
        int secondLastType = -1;
        int currentRes = 1;
        int lastFruitCount = 0;
        int result = 0;
        for (int j = 0; j < tree.length; j++) {
            if (tree[j] == lastType || tree[j] == secondLastType) {
                currentRes++;
            } else {
                currentRes = lastFruitCount + 1;
            }

            if (tree[j] == lastType)
                lastFruitCount++;
            else
                lastFruitCount = 1;

            if (tree[j] != lastType) {
                secondLastType = lastType;
                lastType = tree[j];
            }
            result = Math.max(result, currentRes);
        }
        return result;
    }
}
