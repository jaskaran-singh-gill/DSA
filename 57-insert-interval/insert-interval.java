class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0, m = 0, s = newInterval[0], e = newInterval[1];
        int[][] res = new int[n + 1][2];
        while (i < n && intervals[i][1] < s) res[m++] = intervals[i++];
        while (i < n && intervals[i][0] <= e) {
            if (intervals[i][0] < s) s = intervals[i][0];
            if (intervals[i][1] > e) e = intervals[i][1];
            i++;
        }
        res[m][0] = s; res[m][1] = e; m++;
        while (i < n) res[m++] = intervals[i++];
        return Arrays.copyOf(res, m);
    }
}
