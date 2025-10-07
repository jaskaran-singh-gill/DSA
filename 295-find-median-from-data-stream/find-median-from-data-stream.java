class MedianFinder {
    private final java.util.PriorityQueue<Integer> lo = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
    private final java.util.PriorityQueue<Integer> hi = new java.util.PriorityQueue<>();
    public MedianFinder() {}
    public void addNum(int num) {
        if (lo.isEmpty() || num <= lo.peek()) lo.offer(num); else hi.offer(num);
        if (lo.size() > hi.size() + 1) hi.offer(lo.poll());
        else if (hi.size() > lo.size()) lo.offer(hi.poll());
    }
    public double findMedian() {
        int ls = lo.size(), hs = hi.size();
        if (ls > hs) return lo.peek();
        return (lo.peek() + hi.peek()) / 2.0;
    }
}
