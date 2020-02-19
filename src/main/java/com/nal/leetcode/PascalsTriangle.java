package com.nal.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 31/01/20.
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0)
            return result;

        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        for(int i = 1; i < numRows; i++)
        {
            List<Integer> prev = result.get(result.size()-1);
            List<Integer> sol = new ArrayList<>();
            for(int j = 0; j <= i; j++)
            {
                if(j == 0 || j == i)
                    sol.add(1);
                else
                    sol.add(prev.get(j-1) + prev.get(j));
            }
            result.add(sol);
        }
        return result;
    }
}
