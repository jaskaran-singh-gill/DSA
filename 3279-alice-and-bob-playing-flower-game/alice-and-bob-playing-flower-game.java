class Solution {
    public long flowerGame(int n, int m) {
        long ne = n >> 1, no = (n + 1L) >> 1;
        long me = m >> 1, mo = (m + 1L) >> 1;
        return ne * mo + no * me;
    }
}
