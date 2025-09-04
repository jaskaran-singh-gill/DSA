class Solution {
    public int findClosest(int x, int y, int z) {
        int a = x >= z ? x - z : z - x;
        int b = y >= z ? y - z : z - y;
        return a < b ? 1 : (b < a ? 2 : 0);
    }
}
