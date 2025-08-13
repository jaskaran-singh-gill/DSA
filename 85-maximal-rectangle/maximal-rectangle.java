class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length, ans = 0;
        int[] h = new int[c];
        int[] stack = new int[c + 1];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) h[j] = matrix[i][j] == '1' ? h[j] + 1 : 0;
            int top = -1;
            for (int i2 = 0; i2 <= c; i2++) {
                int cur = i2 == c ? 0 : h[i2];
                while (top != -1 && h[stack[top]] > cur) {
                    int idx = stack[top--];
                    int left = top == -1 ? -1 : stack[top];
                    int area = h[idx] * (i2 - left - 1);
                    if (area > ans) ans = area;
                }
                stack[++top] = i2;
            }
        }
        return ans;
    }
}
