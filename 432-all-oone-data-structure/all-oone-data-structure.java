import java.util.*;

class AllOne {
    static class Node {
        int cnt;
        HashSet<String> keys = new HashSet<>();
        Node prev, next;
        Node(int c){ cnt=c; }
    }
    Node head = new Node(0), tail = new Node(0);
    HashMap<String, Node> map = new HashMap<>();
    public AllOne() { head.next = tail; tail.prev = head; }
    private Node insertAfter(Node a, int cnt){
        Node b = a.next, n = new Node(cnt);
        n.prev = a; n.next = b; a.next = n; b.prev = n;
        return n;
    }
    private void removeIfEmpty(Node n){
        if(n!=head && n!=tail && n.keys.isEmpty()){
            n.prev.next = n.next; n.next.prev = n.prev;
        }
    }
    public void inc(String key) {
        Node cur = map.get(key);
        if(cur==null){
            Node one = head.next;
            if(one==tail || one.cnt!=1) one = insertAfter(head,1);
            one.keys.add(key);
            map.put(key, one);
        }else{
            int nc = cur.cnt+1;
            Node nxt = cur.next;
            if(nxt==tail || nxt.cnt!=nc) nxt = insertAfter(cur,nc);
            nxt.keys.add(key);
            map.put(key, nxt);
            cur.keys.remove(key);
            removeIfEmpty(cur);
        }
    }
    public void dec(String key) {
        Node cur = map.get(key);
        if(cur.cnt==1){
            cur.keys.remove(key);
            map.remove(key);
            removeIfEmpty(cur);
        }else{
            int pc = cur.cnt-1;
            Node prv = cur.prev;
            if(prv==head || prv.cnt!=pc) prv = insertAfter(cur.prev,pc);
            prv.keys.add(key);
            map.put(key, prv);
            cur.keys.remove(key);
            removeIfEmpty(cur);
        }
    }
    public String getMaxKey() {
        Node n = tail.prev;
        if(n==head) return "";
        return n.keys.iterator().next();
    }
    public String getMinKey() {
        Node n = head.next;
        if(n==tail) return "";
        return n.keys.iterator().next();
    }
}
