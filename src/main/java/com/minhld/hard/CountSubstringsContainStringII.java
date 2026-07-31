package com.minhld.hard;

public class CountSubstringsContainStringII extends Thread {
    public void run() {
        String w1 = "bcca";
        String w2 = "abc";
        System.out.println("res = " + validSubstringCount(w1, w2));
    }

    public long validSubstringCount(String word1, String word2) {
        if (word2.length() > word1.length()) return 0;

        char[] w1s = word1.toCharArray();
        char[] w2s = word2.toCharArray();
        int w1len = w1s.length, w2len = w2s.length;

        long ret = 0;
        int[] v2 = new int[26];
        for (char c : w2s) v2[c - 'a']++;

        int l = 0, missing = w2len;
        for (int r = 0; r < w1len; r++) {
            int right = w1s[r] - 'a';
            if (v2[right] > 0) missing--;
            v2[right]--;

            while (missing == 0) {
                ret += w1len - r;

                int left = w1s[l] - 'a';
                v2[left]++;
                if (v2[left] > 0) missing++;
                l++;
            }
        }
        return ret;
    }

    /*
    public long validSubstringCount(String word1, String word2) {
        if (word2.length() > word1.length()) return 0;

        char[] w1s = word1.toCharArray();
        int w1len = w1s.length, w2len = word2.length();

        int[] v2 = new int[26];
        for (char c : word2.toCharArray()) v2[c - 'a']++;

        long ret = 0;
        for (int i = 0; i <= w1len - w2len; i++) {
            int[] v1 = new int[26];
            int missing = w2len;

            for (int k = i; k < w1len; k++) {
                int c = w1s[k] - 'a';
                if (v2[c] > 0 && v1[c] < v2[c]) missing--;
                v1[c]++;

                if (missing == 0) {
                    ret += w1len - k;
                    break;
                }
            }
        }
        return ret;
    }

    public long validSubstringCount(String word1, String word2) {
        if (word2.length() > word1.length()) return 0;

        char[] w1s = word1.toCharArray();
        char[] w2s = word2.toCharArray();
        int w1len = w1s.length, w2len = w2s.length;

        long ret = 0;
        int[] v2 = new int[26];
        for (char c : w2s) v2[c - 'a']++;

        int l = 0, missing = w2len;
        for (int r = 0; r < w1len; r++) {
            int right = w1s[r] - 'a';
            if (v2[right] > 0) missing--;
            v2[right]--;

            while (missing == 0) {
                ret += w1len - r;

                int left = w1s[l] - 'a';
                v2[left]++;
                if (v2[left] > 0) missing++;
                l++;
            }
        }
        return ret;
    }

    public long validSubstringCount(String word1, String word2) {
        if (word2.length() > word1.length()) return 0;

        char[] w1s = word1.toCharArray();
        char[] w2s = word2.toCharArray();
        int w1len = w1s.length, w2len = w2s.length;

        long ret = 0;
        int[] v2 = new int[26];
        for (char c : w2s) v2[c - 'a']++;

        int[] v1;
        for (int i = 0; i <= w1len - w2len; i++) {
            int k = i + w2len;
            while (k <= w1len) {
                v1 = new int[26];
                for (int j = i; j < k; j++) {
                    v1[w1s[j] - 'a']++;
                }
                if (isContains(v1, v2)) {
                    ret += w1len - k + 1;
                    k = w1len + 1;
                } else k++;
            }
        }
        return ret;
    }

    private boolean isContains(int[] v1, int[] v2) {
        for (int i = 0; i < v1.length; i++) {
            if (v1[i] < v2[i]) return false;
        }
        return true;
    }
    */

    public static void main(String[] args) {
        new CountSubstringsContainStringII().start();
    }
}
