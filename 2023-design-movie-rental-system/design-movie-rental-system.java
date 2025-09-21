
class MovieRentingSystem {

    static final class Av {
        final int price, shop;
        Av(int price, int shop) { this.price = price; this.shop = shop; }
    }
    static final class Ren {
        final int price, shop, movie;
        Ren(int price, int shop, int movie) { this.price = price; this.shop = shop; this.movie = movie; }
    }

    final Map<Integer, TreeSet<Av>> avail = new HashMap<>();
    final TreeSet<Ren> rented = new TreeSet<>((a,b)->{
        if (a.price != b.price) return a.price - b.price;
        if (a.shop != b.shop) return a.shop - b.shop;
        return a.movie - b.movie;
    });
    final HashMap<Long, Integer> priceMap = new HashMap<>();

    static long key(int shop, int movie) { return (((long)shop) << 20) | (movie & 0xFFFFF); }

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int s = e[0], m = e[1], p = e[2];
            priceMap.put(key(s,m), p);
            TreeSet<Av> ts = avail.get(m);
            if (ts == null) {
                ts = new TreeSet<>((x,y)->{
                    if (x.price != y.price) return x.price - y.price;
                    return x.shop - y.shop;
                });
                avail.put(m, ts);
            }
            ts.add(new Av(p, s));
        }
    }
    
    public List<Integer> search(int movie) {
        TreeSet<Av> ts = avail.get(movie);
        ArrayList<Integer> res = new ArrayList<>(5);
        if (ts == null || ts.isEmpty()) return res;
        Iterator<Av> it = ts.iterator();
        for (int k = 0; k < 5 && it.hasNext(); k++) res.add(it.next().shop);
        return res;
    }
    
    public void rent(int shop, int movie) {
        int p = priceMap.get(key(shop,movie));
        TreeSet<Av> ts = avail.get(movie);
        if (ts != null) ts.remove(new Av(p, shop));
        rented.add(new Ren(p, shop, movie));
    }
    
    public void drop(int shop, int movie) {
        int p = priceMap.get(key(shop,movie));
        rented.remove(new Ren(p, shop, movie));
        TreeSet<Av> ts = avail.get(movie);
        if (ts == null) {
            ts = new TreeSet<>((x,y)->{
                if (x.price != y.price) return x.price - y.price;
                return x.shop - y.shop;
            });
            avail.put(movie, ts);
        }
        ts.add(new Av(p, shop));
    }
    
    public List<List<Integer>> report() {
        ArrayList<List<Integer>> res = new ArrayList<>(5);
        Iterator<Ren> it = rented.iterator();
        for (int k = 0; k < 5 && it.hasNext(); k++) {
            Ren r = it.next();
            res.add(Arrays.asList(r.shop, r.movie));
        }
        return res;
    }
}
