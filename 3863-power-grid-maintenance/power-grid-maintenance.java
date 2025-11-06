
class Solution {
    static class DSU {
        int[] p, sz;
        DSU(int n){ p=new int[n+1]; sz=new int[n+1]; for(int i=1;i<=n;i++){p[i]=i; sz[i]=1;} }
        int find(int x){ while(p[x]!=x){ p[x]=p[p[x]]; x=p[x]; } return x; }
        void union(int a,int b){
            int ra=find(a), rb=find(b);
            if(ra==rb) return;
            if(sz[ra]<sz[rb]){int t=ra;ra=rb;rb=t;}
            p[rb]=ra; sz[ra]+=sz[rb];
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu=new DSU(c);
        for(int[] e:connections) dsu.union(e[0],e[1]);
        Map<Integer,List<Integer>> comp=new HashMap<>();
        for(int i=1;i<=c;i++){
            int r=dsu.find(i);
            comp.computeIfAbsent(r,k->new ArrayList<>()).add(i);
        }
        int[] head=new int[c+1];
        int[] next=new int[c+1];
        boolean[] on=new boolean[c+1];
        Arrays.fill(on,true);
        for(Map.Entry<Integer,List<Integer>> en:comp.entrySet()){
            List<Integer> lst=en.getValue();
            Collections.sort(lst);
            int prev=0;
            for(int v:lst){
                if(prev==0) head[en.getKey()]=v;
                else next[prev]=v;
                prev=v;
            }
        }
        int m=0;
        for(int[] q:queries) if(q[0]==1) m++;
        int[] ans=new int[m];
        int idx=0;
        for(int[] q:queries){
            int t=q[0], x=q[1];
            if(t==1){
                if(on[x]) ans[idx++]=x;
                else{
                    int r=dsu.find(x);
                    int h=head[r];
                    ans[idx++]=h==0?-1:h;
                }
            }else{
                if(on[x]){
                    on[x]=false;
                    int r=dsu.find(x);
                    if(head[r]==x){
                        int h=next[x];
                        while(h!=0 && !on[h]) h=next[h];
                        head[r]=h;
                    }
                }
            }
        }
        return ans;
    }
}
