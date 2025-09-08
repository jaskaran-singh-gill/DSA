import java.util.HashMap;

class LRUCache {
    static final class Node { int k,v; Node p,n; Node(){} Node(int k,int v){this.k=k;this.v=v;} }
    int cap, sz;
    Node h = new Node(), t = new Node();
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>(capacity<<1);
        h.n = t; t.p = h;
    }
    private void add(Node x){ Node a=h.n; h.n=x; x.p=h; x.n=a; a.p=x; }
    private void rm(Node x){ x.p.n=x.n; x.n.p=x.p; }
    public int get(int key) {
        Node x = map.get(key);
        if (x==null) return -1;
        rm(x); add(x);
        return x.v;
    }
    public void put(int key, int value) {
        Node x = map.get(key);
        if (x!=null){ x.v=value; rm(x); add(x); return; }
        if (sz==cap){ Node y=t.p; rm(y); map.remove(y.k); sz--; }
        Node n=new Node(key,value); add(n); map.put(key,n); sz++;
    }
}
