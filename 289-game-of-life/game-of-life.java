class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int di = -1; di <= 1; di++) {
                    int r = i + di;
                    if (r < 0 || r >= m) continue;
                    for (int dj = -1; dj <= 1; dj++) {
                        if (di == 0 && dj == 0) continue;
                        int c = j + dj;
                        if (c < 0 || c >= n) continue;
                        live += board[r][c] & 1;
                    }
                }
                int cur = board[i][j] & 1;
                if ((cur == 1 && (live == 2 || live == 3)) || (cur == 0 && live == 3)) board[i][j] |= 2;
            }
        }
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                board[i][j] >>= 1;
    }
}
