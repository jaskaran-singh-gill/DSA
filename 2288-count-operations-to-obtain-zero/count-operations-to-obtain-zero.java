class Solution {
    public int countOperations(int num1, int num2) {
        int a = num1, b = num2, ops = 0;
        if (a == 0 || b == 0) return 0;
        while (a != 0 && b != 0) {
            if (a < b) { int t = a; a = b; b = t; }
            ops += a / b;
            a %= b;
        }
        return ops;
    }
}
