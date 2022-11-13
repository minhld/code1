package com.minhld.easy;

import java.util.Arrays;

public class FirstPalindromic extends Thread {
    public void run() {

    }

    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(getRevertString(words[i]))) {
                return words[i];
            }
        }
        return "";
    }

    private String getRevertString(String s) {
        StringBuffer buff = new StringBuffer();
        for (int i = s.length() - 1; i >=0; i--) {
            buff.append(s.charAt(i));
        }
        return buff.toString();
    }

    public static void main(String args[]) {
        new FirstPalindromic().start();
    }
}
