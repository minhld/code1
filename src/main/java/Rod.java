public class Rod extends Thread {
    public void run() {
        // int[] values = {1, 3, 7, 1, 9, 4, 2, 5, 7, 12, 2, 6, 7, 3, 9, 11, 14, 2, 12, 34, 2, 7, 53, 3, 34, 21, 29, 2, 3, 5, 6, 16 };
        int[] values = {3, 7, 1, 3, 9};
        long startTime = System.nanoTime();
        System.out.println("max (recursive) = " + getMaxRod_Recursive(values, values.length));
        System.out.println("take " + (System.nanoTime() - startTime) + "ns");
        startTime = System.nanoTime();
        System.out.println("max (dp) = " + getMaxRod(values, values.length));
        System.out.println("take " + (System.nanoTime() - startTime) + "ns");
    }

    int getMaxRod(int[] values, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int max = -1;
        for (int i = 1; i <= n; i++) {
            max = -1;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, values[j] + dp[i - j - 1]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    int getMaxRod_Recursive(int[] values, int n) {
        if (n <= 0) {
            return 0;
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, values[i] + getMaxRod_Recursive(values, n - i - 1));
        }
        return max;
    }

    public static void main(String args[]) {
        new Rod().start();
    }
}
