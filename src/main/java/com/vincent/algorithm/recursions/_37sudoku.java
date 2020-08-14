package com.vincent.algorithm.recursions;

public class _37sudoku {
    public void solveSudoku(char[][] board) {

    }

    public boolean dfs(char[][] board) {

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (dfs(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        // 判断第i行是否有C
        for (int k = 0; i < board.length; i++) {
            if (board[i][k] == c) return false;
        }
        // 判断j列没有c
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == c) return false;
        }
        return true;
    }

    public boolean dfs2(char[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++) {
                for (char c = '0'; c < '9'; c++) {
                    if (board[i][j] != '.') continue;
                    if (isValid(board, i, j, c)) {
                        board[i][j] = c;
                        if (dfs(board)) {
                            return true;
                        }
                    } else {
                        board[i][j] = '.';
                    }
                }
                return false;
            }

        return true;
    }
}
