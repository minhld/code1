package com.minhld.easy;

public class HappyNumber extends Thread {
    public void run() {
        isHappy(15);
    }

    public boolean isHappy(int n) {
        String nStr = Integer.valueOf(n).toString();
        System.out.println(nStr + ":" + digitSquare(nStr));

        return false;
    }

    private int digitSquare(String nStr) {
        return nStr.chars()
                .mapToObj(c -> (char) c)
                .mapToInt(c -> (int) c)
                .reduce(0, Integer::sum);
    }

    public static void main(String args[]) {
        new HappyNumber().start();
    }
}
