class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxD = -1, ans = 0;
        for (int[] d : dimensions) {
            int l = d[0], w = d[1];
            int diag2 = l * l + w * w;
            int area = l * w;
            if (diag2 > maxD || (diag2 == maxD && area > ans)) {
                maxD = diag2;
                ans = area;
            }
        }
        return ans;
    }
}
