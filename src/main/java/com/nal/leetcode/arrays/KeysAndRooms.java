package com.nal.leetcode.arrays;

import java.util.List;
import java.util.Stack;

/**
 * Created by nishant on 05/03/20.
 * 841. Keys and Rooms
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * Initially, all the rooms start locked (except for room 0).
 * You can walk back and forth between rooms freely.
 * Return true if and only if you can enter every room.
 * Example 1:
 * Input: [[1],[2],[3],[]]
 * Output: true
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() == 0)
            return true;

        int roomCount = rooms.size();
        boolean[] visited = new boolean[roomCount];
        Stack<Integer> keys = new Stack<>();
        keys.add(0);

        while (!keys.isEmpty()) {
            int room = keys.pop();
            visited[room] = true;
            for (int key : rooms.get(room)) {
                if (!visited[key])
                    keys.push(key);
            }
        }

        for (boolean value : visited) {
            if (!value) {
                return false;
            }
        }
        return true;
    }
}
