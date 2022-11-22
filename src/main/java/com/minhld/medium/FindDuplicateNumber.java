package com.minhld.medium;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {
    public int findDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public int findDuplicate(int[] nums) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set1.contains(nums[i])) {
                return nums[i];
            } else {
                set1.add(nums[i]);
            }
        }
        return 0;
    }
}
