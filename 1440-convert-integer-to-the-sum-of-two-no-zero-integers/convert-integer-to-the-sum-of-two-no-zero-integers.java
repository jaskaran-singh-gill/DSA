class Solution {
    private boolean ok(int x){
        while(x>0){ if(x%10==0) return false; x/=10; }
        return true;
    }
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) if (ok(a) && ok(n - a)) return new int[]{a, n - a};
        return new int[]{1, n - 1};
    }
}
