import java.util.*;

class Router {

    static final class Key {
        final int s, d, t;
        Key(int s, int d, int t) { this.s = s; this.d = d; this.t = t; }
        public boolean equals(Object o) { if (this == o) return true; if (!(o instanceof Key)) return false; Key k = (Key)o; return s == k.s && d == k.d && t == k.t; }
        public int hashCode() { int h = 146959810; h = (h ^ s) * 16777619; h = (h ^ d) * 16777619; h = (h ^ t) * 16777619; return h; }
    }

    static final class DestData {
        ArrayList<Integer> ts = new ArrayList<>();
        int start = 0;
        void add(int x) { ts.add(x); }
        void removeFront() {
            start++;
            if (start >= 512 && start * 2 > ts.size()) {
                ts = new ArrayList<>(ts.subList(start, ts.size()));
                start = 0;
            }
        }
        int countInRange(int l, int r) {
            if (start >= ts.size()) return 0;
            int lb = lowerBound(ts, start, l);
            int ub = upperBound(ts, start, r);
            if (lb > ub) return 0;
            return Math.max(0, ub - lb);
        }
        static int lowerBound(ArrayList<Integer> a, int s, int x) {
            int lo = s, hi = a.size();
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (a.get(mid) >= x) hi = mid; else lo = mid + 1;
            }
            return lo;
        }
        static int upperBound(ArrayList<Integer> a, int s, int x) {
            int lo = s, hi = a.size();
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (a.get(mid) > x) hi = mid; else lo = mid + 1;
            }
            return lo;
        }
    }

    final int limit;
    final ArrayDeque<int[]> q = new ArrayDeque<>();
    final HashSet<Key> set = new HashSet<>();
    final HashMap<Integer, DestData> destMap = new HashMap<>();

    public Router(int memoryLimit) {
        this.limit = memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        Key k = new Key(source, destination, timestamp);
        if (!set.add(k)) return false;
        q.addLast(new int[]{source, destination, timestamp});
        DestData dd = destMap.get(destination);
        if (dd == null) { dd = new DestData(); destMap.put(destination, dd); }
        dd.add(timestamp);
        if (q.size() > limit) {
            int[] rem = q.pollFirst();
            set.remove(new Key(rem[0], rem[1], rem[2]));
            DestData rd = destMap.get(rem[1]);
            if (rd != null) rd.removeFront();
        }
        return true;
    }
    
    public int[] forwardPacket() {
        if (q.isEmpty()) return new int[0];
        int[] rem = q.pollFirst();
        set.remove(new Key(rem[0], rem[1], rem[2]));
        DestData rd = destMap.get(rem[1]);
        if (rd != null) rd.removeFront();
        return rem;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        DestData dd = destMap.get(destination);
        if (dd == null) return 0;
        return dd.countInRange(startTime, endTime);
    }
}
