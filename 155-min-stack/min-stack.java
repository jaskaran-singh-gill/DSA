class MinStack {
    int[] a,b; int n;
    public MinStack() { a=new int[16]; b=new int[16]; }
    public void push(int val) {
        if (n==a.length) {
            int m=a.length<<1;
            int[] na=new int[m], nb=new int[m];
            System.arraycopy(a,0,na,0,n);
            System.arraycopy(b,0,nb,0,n);
            a=na; b=nb;
        }
        a[n]=val;
        b[n]= n==0? val : (b[n-1]<val? b[n-1]:val);
        n++;
    }
    public void pop() { n--; }
    public int top() { return a[n-1]; }
    public int getMin() { return b[n-1]; }
}
