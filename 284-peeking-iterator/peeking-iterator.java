
class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> it;
    private Integer buf;
    private boolean hasBuf;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.it = iterator;
        if (it.hasNext()) { buf = it.next(); hasBuf = true; }
    }
    
    public Integer peek() {
        return buf;
    }
    
    @Override
    public Integer next() {
        Integer res = buf;
        if (it.hasNext()) buf = it.next(); else { buf = null; hasBuf = false; }
        return res;
    }
    
    @Override
    public boolean hasNext() {
        return hasBuf;
    }
}
