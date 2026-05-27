package com.minhld.medium;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JumpGame7 extends Thread {
    public void run() {
        String input = loadInput();
        System.out.println("result = " + canReach(input, 1, 49999));
    }

    public static void main(String[] args) {
        new JumpGame7().start();
    }

    private String loadInput() {
        try {
            return Files.readString(Path.of("src/main/resources/jump_game7_large_input_1.txt")).trim();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read JumpGame7 input", e);
        }
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();
        int fb = 0, lb = 0;
        while (lb < len - 1) {
            List<Integer> b = new ArrayList<>();
            for (int i = fb + minJump; i <= Math.min(lb + maxJump, len - 1); i++) {
                if (s.charAt(i) == '0') b.add(i);
            }
            if (b.isEmpty()) return false;
            fb = b.get(0);
            lb = b.get(b.size() - 1);
        }
        return (fb <= len - 1 && lb >= len - 1);
    }
}
