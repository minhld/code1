package com.minhld.medium;

import java.util.List;
import java.util.Stack;

public class SearchWord extends Thread {
    public void run() {
//        char[][] board = {
//                {'A','B'},
//                {'C','D'}
//        };
//        String word = "ABDC";
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
        int[][] mark = new int[board.length][board[0].length];  // array to store visited cells
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (scanWord(word, board, mark, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean scanWord(String word, char[][] board, int[][] mark, int i, int j, int wIdx) {
        if (board[i][j] != word.charAt(wIdx)) return false;
        mark[i][j] = 1;         // check visited cell
        if (wIdx++ == word.length() - 1) return true;
        // check 4 surrounding cells
        if (i > 0 && mark[i - 1][j] == 0 && board[i - 1][j] == word.charAt(wIdx) && scanWord(word, board, mark, i - 1, j, wIdx)) return true;
        if (j > 0 && mark[i][j - 1] == 0 && board[i][j - 1] == word.charAt(wIdx) && scanWord(word, board, mark, i, j - 1, wIdx)) return true;
        if (i < board.length - 1 && mark[i + 1][j] == 0 && board[i + 1][j] == word.charAt(wIdx) && scanWord(word, board, mark, i + 1, j, wIdx)) return true;
        if (j < board[0].length - 1 && mark[i][j + 1] == 0 && board[i][j + 1] == word.charAt(wIdx) && scanWord(word, board, mark, i, j + 1, wIdx)) return true;
        // uncheck visited cell if there is no further moves
        mark[i][j] = 0;
        return false;
    }
}
