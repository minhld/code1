package com.minhld.easy;

public class ValidPalindrome extends Thread {
    public void run() {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(s.replaceAll("[^a-z0-9]", ""));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        StringBuffer revertedS = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            revertedS.append(s.charAt(i));
        }
        return s.equals(revertedS.toString());
    }

    public static void main(String args[]) {
        new ValidPalindrome().start();
    }
}
