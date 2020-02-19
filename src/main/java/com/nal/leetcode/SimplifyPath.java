package com.nal.leetcode;

import java.util.Stack;

/**
 * Created by nishant on 04/02/20.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return path;

        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/+");
        for (String part : parts) {
            if (part.equals("..") && !stack.isEmpty())
                stack.pop();
            else if (part.length() != 0 && !part.equals(".") && !part.equals(".."))
                stack.push(part);
        }
        return "/" + String.join("/", stack);
    }

}
