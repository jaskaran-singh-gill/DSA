class Solution{
    public long maximizeXorAndXor(int[] nums){
        int n=nums.length, N=1<<n, FULL=N-1;
        int[] xor=new int[N];
        long[] and=new long[N];
        and[0]=-1L;
        for(int m=1;m<N;m++){
            int lsb=m&-m, i=Integer.numberOfTrailingZeros(lsb), p=m^lsb;
            xor[m]=xor[p]^nums[i];
            and[m]=and[p]==-1L?nums[i]:(and[p]&nums[i]);
        }
        long[] best=new long[N];
        int[] base=new int[31];
        for(int m=0;m<N;m++){
            java.util.Arrays.fill(base,0);
            int s=xor[m], allow=~s;
            for(int tmp=m;tmp!=0;tmp^=tmp&-tmp){
                int idx=Integer.numberOfTrailingZeros(tmp&-tmp), v=nums[idx]&allow;
                if(v==0)continue;
                for(int b=30;b>=0;b--){
                    if((v>>b&1)==0)continue;
                    if(base[b]==0){base[b]=v;break;}
                    v^=base[b];
                }
            }
            int y=0;
            for(int b=30;b>=0;b--){
                int cand=y^base[b];
                if(cand>y)y=cand;
            }
            best[m]=(long)s+((long)y<<1);
        }
        long ans=0;
        for(int b=0;b<N;b++){
            long val=(and[b]==-1L?0:and[b])+best[FULL^b];
            if(val>ans)ans=val;
        }
        return ans;
    }
}
