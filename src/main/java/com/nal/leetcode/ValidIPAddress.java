package com.nal.leetcode;

/**
 * Created by nishant on 05/02/20.
 */
public class ValidIPAddress {

    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0)
            return "Neither";
        if (IP.contains(".")) {
            String[] parts = IP.split("\\.");
            if (parts.length != 4 || IP.charAt(IP.length() - 1) == '.')
                return "Neither";
            for (String part : parts) {
                if (!isValidIP4Part(part))
                    return "Neither";
            }
            return "IPv4";
        } else if (IP.contains(":")) {
            String[] parts = IP.split(":");
            if (parts.length != 8 || IP.charAt(IP.length() - 1) == ':')
                return "Neither";
            for (String part : parts) {
                if (!isValidIP6Part(part))
                    return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isValidIP4Part(String part) {
        if (part == null || part.length() == 0 || part.length() > 3)
            return false;
        if (part.startsWith("0") && part.length() > 1)
            return false;
        for (char c : part.toCharArray()) {
            if (c < '0' || c > '9')
                return false;
        }
        int value = Integer.parseInt(part);
        if (value < 0 || value > 255)
            return false;
        return true;
    }

    private boolean isValidIP6Part(String part) {
        if (part == null || part.length() == 0 || part.length() > 4)
            return false;
        for (char c : part.toCharArray()) {
            if (!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F'))
                return false;
        }
        return true;
    }
}
