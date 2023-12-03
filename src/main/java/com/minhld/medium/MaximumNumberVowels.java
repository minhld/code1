package com.minhld.medium;

public class MaximumNumberVowels {
    public int maxVowels(String s, int k) {
        int n = s.length(), cnt = 0, max = 0;
        String t = "aeiou";
        char[] c = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if (t.indexOf(c[i]) >= 0) cnt++;
        }
        max = Math.max(max, cnt);
        for (int i = 1; i <= n - k; i++) {
            if (t.indexOf(c[i - 1]) >= 0) cnt--;
            if (t.indexOf(c[i + k - 1]) >= 0) cnt++;
            max = Math.max(max, cnt);
        }
        return max;
    }
}
