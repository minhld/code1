package com.minhld.greedy;

public class BreakPalindrome {
    public String breakPalindrome(String p) {
        if (p.length() == 1) {
            return "";
        }
        StringBuffer buff = new StringBuffer(p);
        for (int i = 0; i < p.length(); i++) {
            if (p.length() % 2 == 1 && i == p.length() / 2) continue;
            if (p.charAt(i) != 'a') {
                return buff.replace(i, i + 1, Character.toString('a'))
                        .toString();
            }
        }
        int last = p.length() - 1;
        return buff.replace(last, last + 1, Character.toString((char)((int) p.charAt(last) + 1)))
                .toString();
    }
}
