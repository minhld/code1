package com.minhld.medium;

public class NumberZeroFilledSubArrays {
    public long zeroFilledSubArray(int[] nums) {
        int n = nums.length, i = 0, s = 0, j = 0;
        long count = 0;
        while (i < n) {
            if (nums[i] == 0) {
                count++;
                s = i;
                j = i + 1;
                while (j < n) {
                    if (nums[j] == 0) {
                        count += j - s + 1;
                        i = ++j;
                    } else break;
                }
            }
            i++;
        }
        return count;
    }
}
