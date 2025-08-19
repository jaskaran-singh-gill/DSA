class Solution {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1, v = 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) a[top][j] = v++;
            for (int i = top + 1; i <= bottom; i++) a[i][right] = v++;
            if (top < bottom && left < right) {
                for (int j = right - 1; j >= left; j--) a[bottom][j] = v++;
                for (int i = bottom - 1; i > top; i--) a[i][left] = v++;
            }
            top++; left++; bottom--; right--;
        }
        return a;
    }
}
