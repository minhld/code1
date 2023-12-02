package com.minhld.medium;

public class LongestAlphabeticalContinuousSubstring extends Thread {
    public void run() {
        String sample = "nkvexzqgctjxwqnzneuvtuvyvrmhfbawyabanxadvlzllpwnanjxyjhhzzjokcszjeooitnvadkuzsnklxriwo";
        int maxConLength = longestContinuousSubstring(sample);
        System.out.println("Max = " + maxConLength);
    }

    public static void main(String[] args) {
        new LongestAlphabeticalContinuousSubstring().start();
    }

    public int longestContinuousSubstring(String s) {
        int n = s.length(), i = 0, len = 0, j = 0, max = 0;
        char [] c = s.toCharArray();
        while (i < n) {
            j = i + 1;
            len = 1;
            while (j < n) {
                if (c[j] - c[j - 1] == 1) {
                    len++;
                    j++;
                } else break;
            }
            max = Math.max(len, max);
            i++;
        }
        return max;
    }
}
