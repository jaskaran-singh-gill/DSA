class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] p=new int[n], sz=new int[n];
        for(int i=0;i<n;i++){p[i]=i;sz[i]=1;}
        for(int[] e:edges){
            int a=e[0],b=e[1];
            int ra=find(p,a), rb=find(p,b);
            if(ra!=rb){
                if(sz[ra]<sz[rb]){int t=ra;ra=rb;rb=t;}
                p[rb]=ra; sz[ra]+=sz[rb];
            }
        }
        int[] and=new int[n];
        for(int i=0;i<n;i++) and[i]=-1;
        for(int[] e:edges){
            int r=find(p,e[0]);
            if(and[r]==-1) and[r]=e[2]; else and[r]&=e[2];
        }
        int m=query.length;
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            int s=query[i][0], t=query[i][1];
            int rs=find(p,s), rt=find(p,t);
            if(rs!=rt || and[rs]==-1) ans[i]=-1; else ans[i]=and[rs];
        }
        return ans;
    }
    private int find(int[] p,int x){
        while(p[x]!=x){p[x]=p[p[x]];x=p[x];}
        return x;
    }
}
