package com.nal.leetcode.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by nishant on 16/02/20.
 * 295. Find Median from Data Stream
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * For example,
 * [2,3,4], the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 */
public class FindMedianFromDataStream {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
            rebalanceHeaps(maxHeap, minHeap);
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek();
        } else {
            return ((double) (minHeap.peek() + maxHeap.peek())) / 2;
        }
    }

    private void rebalanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.remove());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.remove());
        }
    }

}
