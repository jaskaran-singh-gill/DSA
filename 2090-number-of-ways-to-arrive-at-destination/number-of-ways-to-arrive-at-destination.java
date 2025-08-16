class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD=1_000_000_007;
        int m=roads.length;
        int[] head=new int[n];
        for(int i=0;i<n;i++) head[i]=-1;
        int[] to=new int[m<<1], nxt=new int[m<<1], w=new int[m<<1];
        int idx=0;
        for(int[] r:roads){
            int u=r[0], v=r[1], ww=r[2];
            to[idx]=v; w[idx]=ww; nxt[idx]=head[u]; head[u]=idx++;
            to[idx]=u; w[idx]=ww; nxt[idx]=head[v]; head[v]=idx++;
        }
        long INF=Long.MAX_VALUE>>>2;
        long[] dist=new long[n];
        for(int i=0;i<n;i++) dist[i]=INF;
        long[] ways=new long[n];
        dist[0]=0; ways[0]=1;
        int cap=(m<<1)+5;
        long[] hd=new long[cap];
        int[] hu=new int[cap];
        int hs=0;
        { long d=0; int u=0; int i=++hs; while(i>1){int p=i>>1; if(hd[p]<=d) break; hd[i]=hd[p]; hu[i]=hu[p]; i=p;} hd[i]=d; hu[i]=u; }
        while(hs>0){
            long d=hd[1]; int u=hu[1];
            long td=hd[hs]; int tu=hu[hs--];
            int i=1,j=2; while(j<=hs){ if(j<hs && hd[j+1]<hd[j]) j++; if(td<=hd[j]) break; hd[i]=hd[j]; hu[i]=hu[j]; i=j; j<<=1;} hd[i]=td; hu[i]=tu;
            if(d!=dist[u]) continue;
            for(int e=head[u]; e!=-1; e=nxt[e]){
                int v=to[e];
                long nd=d+(long)w[e];
                if(nd<dist[v]){
                    dist[v]=nd;
                    ways[v]=ways[u];
                    long pd=nd; int pu=v; int k=++hs; while(k>1){int p=k>>1; if(hd[p]<=pd) break; hd[k]=hd[p]; hu[k]=hu[p]; k=p;} hd[k]=pd; hu[k]=pu;
                }else if(nd==dist[v]){
                    ways[v]+=ways[u];
                    if(ways[v]>=MOD) ways[v]-=MOD;
                }
            }
        }
        return (int)(ways[n-1]%MOD);
    }
}
