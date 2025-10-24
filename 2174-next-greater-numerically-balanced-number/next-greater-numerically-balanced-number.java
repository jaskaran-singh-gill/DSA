import java.util.*;

class Solution {
    long target;
    long best = Long.MAX_VALUE;
    int[] choose = new int[10];

    public int nextBeautifulNumber(int n) {
        target = n;
        dfsChoose(1, 0);
        return (int) best;
    }

    void dfsChoose(int d, int len) {
        if (len > 9) return;
        if (d == 10) {
            if (len == 0) return;
            generatePermutations(len);
            return;
        }
        dfsChoose(d + 1, len);
        if (len + d <= 9) {
            choose[d] = d;
            dfsChoose(d + 1, len + d);
            choose[d] = 0;
        }
    }

    void generatePermutations(int totalLen) {
        long cur = 0;
        backtrack(totalLen, 0, cur);
    }

    void backtrack(int totalLen, int placed, long cur) {
        if (cur >= best) return;
        if (placed == totalLen) {
            if (cur > target && cur < best) best = cur;
            return;
        }
        for (int d = 1; d <= 9; d++) {
            if (choose[d] > 0) {
                choose[d]--;
                backtrack(totalLen, placed + 1, cur * 10 + d);
                choose[d]++;
            }
        }
    }
}
