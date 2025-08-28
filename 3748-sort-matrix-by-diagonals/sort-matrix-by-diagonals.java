
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int[] buf = new int[n];
        for (int j = 0; j < n; j++) {
            int len = 0, x = 0, y = j;
            while (x < n && y < n) buf[len++] = grid[x++][y++];
            Arrays.sort(buf, 0, len);
            x = 0; y = j;
            if (j == 0) {
                for (int k = len - 1; k >= 0; k--) grid[x++][y++] = buf[k];
            } else {
                for (int k = 0; k < len; k++) grid[x++][y++] = buf[k];
            }
        }
        for (int i = 1; i < n; i++) {
            int len = 0, x = i, y = 0;
            while (x < n && y < n) buf[len++] = grid[x++][y++];
            Arrays.sort(buf, 0, len);
            x = i; y = 0;
            for (int k = len - 1; k >= 0; k--) grid[x++][y++] = buf[k];
        }
        return grid;
    }
}
