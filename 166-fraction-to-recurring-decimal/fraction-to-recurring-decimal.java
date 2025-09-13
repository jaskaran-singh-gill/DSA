import java.util.HashMap;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        long n = numerator, d = denominator;
        boolean neg = (n ^ d) < 0;
        n = Math.abs(n); d = Math.abs(d);
        StringBuilder sb = new StringBuilder();
        if (neg) sb.append('-');
        sb.append(n / d);
        long r = n % d;
        if (r == 0) return sb.toString();
        sb.append('.');
        HashMap<Long,Integer> pos = new HashMap<>(16384);
        while (r != 0) {
            Integer at = pos.putIfAbsent(r, sb.length());
            if (at != null) {
                int idx = at;
                sb.insert(idx, '(');
                sb.append(')');
                break;
            }
            r *= 10;
            long q = r / d;
            sb.append((char)('0' + q));
            r -= q * d;
        }
        return sb.toString();
    }
}
