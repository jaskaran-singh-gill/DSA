class Solution {
    public boolean isValidSudoku(char[][] board) {
         int[] rowBits = new int[9];
        int[] colBits = new int[9];
        int[] boxBits = new int[9];
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                int v = ch - '0';
                int m = 1 << v;
                int b = (r / 3) * 3 + (c / 3);
                if ((rowBits[r] & m) > 0 || (colBits[c] & m) > 0 || (boxBits[b] & m) > 0) return false;
                rowBits[r] |= m;
                colBits[c] |= m;
                boxBits[b] |= m;
            }
        }
        return true;
    
    }
}