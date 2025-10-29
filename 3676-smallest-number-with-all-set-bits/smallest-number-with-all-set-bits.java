class Solution {
    public int smallestNumber(int n) {
        int bits = 1;
        while ((1 << bits) - 1 < n) {
            bits++;
        }
        return (1 << bits) - 1;
    }
}
