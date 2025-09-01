class Solution {
    static class N {
        int p, t;
        double g;
        N(int p, int t) { this.p = p; this.t = t; this.g = gain(p, t); }
    }
    static double gain(int p, int t) {
        return (double)(t - p) / (t * (double)(t + 1));
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int m = classes.length;
        java.util.PriorityQueue<N> pq = new java.util.PriorityQueue<>((a,b) -> Double.compare(b.g, a.g));
        double sum = 0;
        for (int[] c : classes) {
            N n = new N(c[0], c[1]);
            sum += c[0] / (double)c[1];
            pq.add(n);
        }
        while (extraStudents-- > 0) {
            N n = pq.poll();
            sum += n.g;
            n.p++; n.t++; n.g = gain(n.p, n.t);
            pq.add(n);
        }
        return sum / m;
    }
}
