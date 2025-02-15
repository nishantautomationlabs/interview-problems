package com.nal.leetcode.string;

/**
 * Created by nishant on 05/02/20.
 * 468. Validate IP Address
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 * Note: You may assume there is no extra space or special characters in the input string.
 */
public class ValidateIPAddress {

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
