package com.minhld.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearch2 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int[][] mark = new int[board.length][board[0].length];  // array to store visited cells
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // for (int k = 0; k < words.length; k++) {
                //     if (wordFound[k] == 0) {
                //         mark = new int[board.length][board[0].length];
                //         if (scanWord(words[k], board, mark, i, j, 0)) {
                //             res.add(words[k]);
                //             wordFound[k] = 1;
                //         }
                //     }
                // }
            }
        }
        return res;
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
