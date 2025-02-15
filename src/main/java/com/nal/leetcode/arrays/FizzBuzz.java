package com.nal.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 05/02/20.
 * 412. Fizz Buzz
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0)
            return result;

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                result.add("FizzBuzz");
            else if (i % 5 == 0)
                result.add("Buzz");
            else if (i % 3 == 0)
                result.add("Fizz");
            else
                result.add(Integer.toString(i));
        }
        return result;
    }
}
