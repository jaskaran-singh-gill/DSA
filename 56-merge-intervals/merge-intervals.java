class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length, m = 0;
        int[][] res = new int[n][2];
        int s = intervals[0][0], e = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int x = intervals[i][0], y = intervals[i][1];
            if (x <= e) {
                if (y > e) e = y;
            } else {
                res[m][0] = s; res[m][1] = e; m++;
                s = x; e = y;
            }
        }
        res[m][0] = s; res[m][1] = e; m++;
        return Arrays.copyOf(res, m);
    }
}
