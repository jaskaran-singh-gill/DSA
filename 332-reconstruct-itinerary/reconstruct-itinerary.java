import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> g = new HashMap<>(tickets.size()<<1);
        for (List<String> e : tickets) g.computeIfAbsent(e.get(0), k -> new PriorityQueue<>()).offer(e.get(1));
        ArrayDeque<String> st = new ArrayDeque<>();
        LinkedList<String> res = new LinkedList<>();
        st.push("JFK");
        while (!st.isEmpty()) {
            String u = st.peek();
            PriorityQueue<String> pq = g.get(u);
            if (pq != null && !pq.isEmpty()) st.push(pq.poll());
            else { res.addFirst(u); st.pop(); }
        }
        return res;
    }
}
