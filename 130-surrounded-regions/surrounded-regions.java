class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        java.util.ArrayDeque<Integer> q = new java.util.ArrayDeque<>(m * n);
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') { board[i][0] = 'T'; q.add(i * n); }
            if (n > 1 && board[i][n - 1] == 'O') { board[i][n - 1] = 'T'; q.add(i * n + n - 1); }
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') { board[0][j] = 'T'; q.add(j); }
            if (m > 1 && board[m - 1][j] == 'O') { board[m - 1][j] = 'T'; q.add((m - 1) * n + j); }
        }
        while (!q.isEmpty()) {
            int idx = q.pollFirst();
            int r = idx / n, c = idx % n;
            if (r > 0 && board[r - 1][c] == 'O') { board[r - 1][c] = 'T'; q.add((r - 1) * n + c); }
            if (r + 1 < m && board[r + 1][c] == 'O') { board[r + 1][c] = 'T'; q.add((r + 1) * n + c); }
            if (c > 0 && board[r][c - 1] == 'O') { board[r][c - 1] = 'T'; q.add(r * n + c - 1); }
            if (c + 1 < n && board[r][c + 1] == 'O') { board[r][c + 1] = 'T'; q.add(r * n + c + 1); }
        }
        for (int i = 0; i < m; i++) {
            char[] row = board[i];
            for (int j = 0; j < n; j++) {
                if (row[j] == 'O') row[j] = 'X';
                else if (row[j] == 'T') row[j] = 'O';
            }
        }
    }
}
