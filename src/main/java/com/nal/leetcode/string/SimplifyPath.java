package com.nal.leetcode.string;

import java.util.Stack;

/**
 * Created by nishant on 04/02/20.
 * 71. Simplify Path
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 * Example 6:
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
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
