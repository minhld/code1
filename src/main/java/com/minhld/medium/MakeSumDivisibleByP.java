package com.minhld.medium;

import java.util.Arrays;

public class MakeSumDivisibleByP extends Thread {
    public void run() {
        int[] data = new int[] { 3,1,4,2 };
        System.out.println("sum = " + Arrays.stream(data).mapToLong(i -> i).sum());
    }

    public static void main(String[] args) {
        new MakeSumDivisibleByP().start();
    }
}
