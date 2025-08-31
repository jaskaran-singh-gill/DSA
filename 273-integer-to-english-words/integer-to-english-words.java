class Solution {
    private static final String[] B20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private static final String[] TENS = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder(64);
        int b = num / 1000000000; if (b != 0) { appendSubThousand(sb, b); appendToken(sb, "Billion"); }
        num %= 1000000000;
        int m = num / 1000000; if (m != 0) { appendSubThousand(sb, m); appendToken(sb, "Million"); }
        num %= 1000000;
        int t = num / 1000; if (t != 0) { appendSubThousand(sb, t); appendToken(sb, "Thousand"); }
        num %= 1000;
        if (num != 0) appendSubThousand(sb, num);
        return sb.toString();
    }
    private void appendSubThousand(StringBuilder sb, int x) {
        if (x >= 100) { appendToken(sb, B20[x / 100]); appendToken(sb, "Hundred"); x %= 100; }
        if (x >= 20) { appendToken(sb, TENS[x / 10]); if ((x %= 10) != 0) appendToken(sb, B20[x]); }
        else if (x != 0) appendToken(sb, B20[x]);
    }
    private void appendToken(StringBuilder sb, String s) {
        if (sb.length() != 0) sb.append(' ');
        sb.append(s);
    }
}
