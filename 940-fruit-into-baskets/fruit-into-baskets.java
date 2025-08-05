class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length, ans = 0, cur = 0, last = -1, second = -1, lastCnt = 0;
        for (int f : fruits) {
            if (f == last || f == second) {
                ++cur;
            } else {
                cur = lastCnt + 1;
            }
            if (f == last) {
                ++lastCnt;
            } else {
                second = last;
                last = f;
                lastCnt = 1;
            }
            if (cur > ans) ans = cur;
        }
        return ans;
    }
}
