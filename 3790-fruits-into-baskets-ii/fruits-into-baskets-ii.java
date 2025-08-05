class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int[] seg = new int[n << 2];
        build(seg, 1, 0, n - 1, baskets);
        int unplaced = 0;
        for (int f : fruits) {
            if (seg[1] < f) {
                ++unplaced;
            } else {
                update(seg, 1, 0, n - 1, f);
            }
        }
        return unplaced;
    }

    private void build(int[] seg, int idx, int l, int r, int[] arr) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int m = (l + r) >>> 1;
        build(seg, idx << 1, l, m, arr);
        build(seg, idx << 1 | 1, m + 1, r, arr);
        seg[idx] = seg[idx << 1] >= seg[idx << 1 | 1] ? seg[idx << 1] : seg[idx << 1 | 1];
    }

    private void update(int[] seg, int idx, int l, int r, int val) {
        if (l == r) {
            seg[idx] = 0;
            return;
        }
        int m = (l + r) >>> 1;
        if (seg[idx << 1] >= val) {
            update(seg, idx << 1, l, m, val);
        } else {
            update(seg, idx << 1 | 1, m + 1, r, val);
        }
        seg[idx] = seg[idx << 1] >= seg[idx << 1 | 1] ? seg[idx << 1] : seg[idx << 1 | 1];
    }
}
