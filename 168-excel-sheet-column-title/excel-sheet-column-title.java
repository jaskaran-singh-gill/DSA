class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        long n = columnNumber;
        while (n > 0) {
            n--;
            sb.append((char)('A' + (n % 26)));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
