
class SummaryRanges {
    boolean[] seen = new boolean[10001];
    public SummaryRanges() {}
    public void addNum(int value) { if (!seen[value]) seen[value] = true; }
    public int[][] getIntervals() {
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i <= 10000; i++) {
            if (!seen[i]) continue;
            int j = i;
            while (j + 1 <= 10000 && seen[j + 1]) j++;
            res.add(new int[]{i, j});
            i = j;
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}
