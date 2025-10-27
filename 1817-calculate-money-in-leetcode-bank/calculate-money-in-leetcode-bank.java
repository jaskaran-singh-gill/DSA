class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7, days = n % 7;
        int total = (weeks * (2 * 28 + (weeks - 1) * 7)) / 2;
        int start = weeks + 1;
        total += (days * (2 * start + (days - 1))) / 2;
        return total;
    }
}
