import java.util.*;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] c = new int[k];
        for (int i = 0; i < k; i++) c[i] = i + 1;
        add(res, c);
        while (true) {
            int i = k - 1;
            while (i >= 0 && c[i] == n - k + 1 + i) i--;
            if (i < 0) break;
            c[i]++;
            for (int j = i + 1; j < k; j++) c[j] = c[j - 1] + 1;
            add(res, c);
        }
        return res;
    }
    private void add(List<List<Integer>> res, int[] c) {
        ArrayList<Integer> list = new ArrayList<>(c.length);
        for (int v : c) list.add(v);
        res.add(list);
    }
}
