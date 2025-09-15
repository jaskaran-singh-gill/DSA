class Solution {
    private int next(int x){
        int s = 0;
        while (x != 0) { int d = x % 10; s += d * d; x /= 10; }
        return s;
    }
    public boolean isHappy(int n) {
        int slow = n, fast = next(n);
        while (fast != 1 && slow != fast) { slow = next(slow); fast = next(next(fast)); }
        return fast == 1;
    }
}
