package com.minhld.medium;

public class SearchWord extends Thread {
    public void run() {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','E','S'},
            {'A','D','E','E'}
        };
        String word = "ABCESEEEFS";
        System.out.print(exist(board, word));
    }

    public static void main(String[] args) {
        new SearchWord().start();
    }

    public boolean exist(char[][] board, String word) {
        int currIdx = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] mark = new int[board.length][board[0].length];
                    if (scanWord(word, board, mark, i, j, 1)) return true;
                }
            }
        }
        return false;
    }

    private boolean scanWord(String word, char[][] board, int[][] mark, int i, int j, int wIdx) {
        mark[i][j] = 1;
        if (wIdx == word.length() - 1) return true;

        if (i > 0 && mark[i - 1][j] == 0 && board[i - 1][j] == word.charAt(wIdx)) {
            if (scanWord(word, board, mark, i - 1, j, wIdx + 1)) return true;
        }
        if (j > 0 && mark[i][j - 1] == 0 && board[i][j - 1] == word.charAt(wIdx)) {
            if (scanWord(word, board, mark, i, j - 1, wIdx + 1)) return true;
        }
        if (i < board.length - 1 && mark[i + 1][j] == 0 && board[i + 1][j] == word.charAt(wIdx)) {
            if (scanWord(word, board, mark, i + 1, j, wIdx + 1)) return true;
        }
        if (j < board[0].length - 1 && mark[i][j + 1] == 0 && board[i][j + 1] == word.charAt(wIdx)) {
            if (scanWord(word, board, mark, i, j + 1, wIdx + 1)) return true;
        }
        return false;
    }
}
