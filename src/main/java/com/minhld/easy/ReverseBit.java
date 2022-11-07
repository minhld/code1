package com.minhld.easy;

public class ReverseBit extends Thread {
    public void run() {
        int n = 43261596;
        reverseBits(n);
    }

    public int reverseBits(int n) {
        int revertedN = 0;
        int count = 1;
        while (count <= 32) {
            int lastBit = n & 1;
            System.out.print(lastBit);
            revertedN = (revertedN << 1) | lastBit;
            n >>= 1;
            count++;
        }
        System.out.println("\n" + revertedN);
        return revertedN;
    }

    public static void main(String args[]) {
        new ReverseBit().start();
    }
}
