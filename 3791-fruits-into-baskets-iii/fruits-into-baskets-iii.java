class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int size = 1;
        while (size < n) size <<= 1;
        int[] seg = new int[size << 1];
        for (int i = 0; i < n; i++) seg[size + i] = baskets[i];
        for (int i = size - 1; i > 0; --i)
            seg[i] = seg[i << 1] > seg[i << 1 | 1] ? seg[i << 1] : seg[i << 1 | 1];

        int unplaced = 0;
        for (int f : fruits) {
            if (seg[1] < f) {
                unplaced++;
                continue;
            }
            int idx = 1;
            while (idx < size) {
                idx = seg[idx << 1] >= f ? idx << 1 : idx << 1 | 1;
            }
            seg[idx] = 0;
            for (idx >>= 1; idx > 0; idx >>= 1)
                seg[idx] = seg[idx << 1] > seg[idx << 1 | 1] ? seg[idx << 1] : seg[idx << 1 | 1];
        }
        return unplaced;
    }
}
