package com.minhld.medium;

public class InterleavingString extends Thread {
    public static void main(String[] args) {
        new InterleavingString().start();
    }
    @Override
    public void run() {
//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbcbcac";
//        String s1 = "accbaabaaabbcbaacbababacaababbcbabaababcaabbbbbcacbaa";
//        String s2 = "cabaabcbabcbaaaacababccbbccaaabaacbbaaabccacabaaccbbcbcb";
//        String s3 = "accbcaaabbaabaaabbcbcbabacbacbababaacaaaaacbabaabbcbccbbabbccaaaaabaabcabbcaabaaabbcbcbbbcacabaaacccbbcbbaacb";
        String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println("res = " + isInterleave(s1, s2, s3));
    }

//    public boolean isInterleave(String s1, String s2, String s3) {
//
//    }

    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }

    int total = 0;
    private boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3) {
        if (i3 == s3.length()) {
            return i1 == s1.length() && i2 == s2.length();
        }
        boolean f = false, s = false;
        if (i1 < s1.length() && i3 < s3.length() && s1.charAt(i1) == s3.charAt(i3)) {
            f = isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1);
            if (f) return true;
        }
        if (i2 < s2.length() && i3 < s3.length() && s2.charAt(i2) == s3.charAt(i3)) {
            s = isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1);
            return s;
        }
        return false;
    }

//    public boolean isInterleave(String s1, String s2, String s3) {
//        int i1 = 0, i2 = 0, i = 0;
//        boolean notFound = true;
//        while (i < s3.length()) {
//            notFound = true;
//            while (i1 < s1.length() && s3.charAt(i) == s1.charAt(i1)) {
//                i1++;
//                i++;
//                notFound = false;
//            }
//            while (i2 < s2.length() && i < s3.length() && s3.charAt(i) == s2.charAt(i2)) {
//                i2++;
//                i++;
//                notFound = false;
//            }
//            if (notFound) return false;
//        }
//        return i1 == s1.length() && i2 == s2.length() && i == s3.length();
//    }
}
