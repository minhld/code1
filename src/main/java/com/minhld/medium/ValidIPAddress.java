package com.minhld.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidIPAddress extends Thread {
    public void run() {
        String[] list1 = new String[] { "1", "2", "3" };
        System.out.println(validIPAddress("172.16.254.10"));

    }

    public static void main(String[] args) {
        new ValidIPAddress().start();
    }

    public String validIPAddress(String queryIP) {
        String[] parts;
        if (queryIP.indexOf(".") > 0) {
            parts = queryIP.split("\\.", -1);
            for (int i = 0; i < parts.length; i++) {
                if (!validIpV4Part(parts[i])) return "Neither";
            }
            return "IPv4";
        }
        if (queryIP.indexOf(":") > 0) {
            parts = queryIP.split(":", -1);
            for (int i = 0; i < parts.length; i++) {
                if (!validIpV6Part(parts[i])) return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }

    private boolean validIpV4Part(String part) {
        if (part.length() <= 0 || part.length() >= 4) return false;
        for (int i = 0; i < part.length(); i++) {
            int c = (int) part.charAt(i);
            if (i == 0 && (c <= 48 || c >= 58) || (i > 0 && (c <= 47 || c >= 58))) return false;
        }
        return Integer.parseInt(part) < 256;
    }

    private boolean validIpV6Part(String part) {
        if (part.length() <= 0 || part.length() >= 5) return false;
        for (int i = 0; i < part.length(); i++) {
            int c = (int) part.charAt(i);
            if (c < 48 || c > 58 && c < 65 || c > 70 && c < 97 || c > 102) return false;
        }
        return true;
    }

}
