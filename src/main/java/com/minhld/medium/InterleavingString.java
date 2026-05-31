package com.minhld.medium;

public class InterleavingString extends Thread {
    public static void main(String[] args) {
        new InterleavingString().start();
    }
    @Override
    public void run() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println("res = " + isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int i1 = 0, i2 = 0, i = 0;
        boolean notFound = true;
        while (i < s3.length()) {
            notFound = true;
            while (i1 < s1.length() && s3.charAt(i) == s1.charAt(i1)) {
                i1++;
                i++;
                notFound = false;
            }
            while (i2 < s2.length() && s3.charAt(i) == s2.charAt(i2)) {
                i2++;
                i++;
                notFound = false;
            }
            if (notFound) return false;
        }
        return true;
    }
}
