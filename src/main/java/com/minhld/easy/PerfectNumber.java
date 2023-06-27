package com.minhld.easy;

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int div = 1, rem = 0;
        int total = div;
        while (num / div >= div) {
            if (num % div == 0) {
                rem = num / div;
                if (rem < num) total += div + rem;
            }
            div++;
        }
        return total == num;
    }
}
