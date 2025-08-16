class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] p=new int[n], sz=new int[n];
        for(int i=0;i<n;i++){p[i]=i;sz[i]=1;}
        for(int[] e:edges){
            int a=find(p,e[0]), b=find(p,e[1]);
            if(a!=b){
                if(sz[a]<sz[b]){int t=a;a=b;b=t;}
                p[b]=a; sz[a]+=sz[b];
            }
        }
        int[] ec=new int[n];
        for(int[] e:edges){
            int r=find(p,e[0]);
            ec[r]++;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(p[i]==i){
                int k=sz[i];
                if(ec[i]==k*(k-1)/2) ans++;
            }
        }
        return ans;
    }
    private int find(int[] p,int x){
        while(p[x]!=x){p[x]=p[p[x]];x=p[x];}
        return x;
    }
}
