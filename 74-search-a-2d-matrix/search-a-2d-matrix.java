class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int v = matrix[mid / n][mid % n];
            if (v == target) return true;
            if (v < target) l = mid + 1; else r = mid - 1;
        }
        return false;
    }
}
