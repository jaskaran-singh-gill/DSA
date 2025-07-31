class Solution {
    public void solveSudoku(char[][] board) 
    {
         int[] rowBits = new int[9];
        int[] colBits = new int[9];
        int[] boxBits = new int[9];
        
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                if (board[r][c] != '.') {
                    int d = board[r][c] - '1';
                    int m = 1 << d;
                    rowBits[r] |= m;
                    colBits[c] |= m;
                    boxBits[(r / 3) * 3 + c / 3] |= m;
                }

        dfs(board, 0, 0, rowBits, colBits, boxBits);
    }

    private boolean dfs(char[][] b, int r, int c, int[] rb, int[] cb, int[] bb) {
        if (r == 9) return true;
        if (c == 9) return dfs(b, r + 1, 0, rb, cb, bb);
        if (b[r][c] != '.') return dfs(b, r, c + 1, rb, cb, bb);
        
        int box = (r / 3) * 3 + c / 3;
        for (int d = 0; d < 9; d++) {
            int m = 1 << d;
            if ((rb[r] & m) != 0 || (cb[c] & m) != 0 || (bb[box] & m) != 0) continue;
            b[r][c] = (char) (d + '1');
            rb[r] |= m;
            cb[c] |= m;
            bb[box] |= m;
            if (dfs(b, r, c + 1, rb, cb, bb)) return true;
            rb[r] ^= m;
            cb[c] ^= m;
            bb[box] ^= m;
            b[r][c] = '.';
        }
        return false;
    }
}