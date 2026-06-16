package com.minhld.medium;

public class MagicString extends Thread {
    public void run() {
        int n = 6;
        System.out.println("Res = " + magicalString(n));
    }

    public int magicalString(int n) {
        int count = 1;
        StringBuffer s = new StringBuffer("122");
        if (n < 3) return 1;
        for (int i = 2; i < n; i++) {
            if (s.charAt(i) == '1') {
                s.append(s.charAt(s.length() - 1) == '1' ? "2" : "1");
                count += 1;
            } else if (s.charAt(i) == '2') {
                s.append(s.charAt(s.length() - 1) == '2' ? "11" : "22");
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new MagicString().start();
    }
}
