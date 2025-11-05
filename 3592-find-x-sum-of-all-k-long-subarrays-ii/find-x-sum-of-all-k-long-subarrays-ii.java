
class Solution {
    static final class Node {
        int val, freq;
        boolean in;
        Node(int v){val=v;}
    }
    static final Comparator<Node> CMP = (a,b)->{
        if (a.freq!=b.freq) return b.freq-a.freq;
        return b.val-a.val;
    };
    public long[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        long[] ans=new long[n-k+1];
        HashMap<Integer,Node> map=new HashMap<>();
        TreeSet<Node> in=new TreeSet<>(CMP), out=new TreeSet<>(CMP);
        long sum=0;
        for(int i=0;i<k;i++) sum=inc(nums[i],map,in,out,sum,x);
        ans[0]=sum;
        for(int i=k;i<n;i++){
            sum=dec(nums[i-k],map,in,out,sum,x);
            sum=inc(nums[i],map,in,out,sum,x);
            ans[i-k+1]=sum;
        }
        return ans;
    }
    long inc(int v, HashMap<Integer,Node> map, TreeSet<Node> in, TreeSet<Node> out, long sum, int x){
        Node nd=map.get(v);
        if(nd==null){ nd=new Node(v); map.put(v,nd); }
        else{
            if(nd.in){ in.remove(nd); sum-= (long)nd.freq*nd.val; }
            else out.remove(nd);
        }
        nd.freq++;
        nd.in=false;
        out.add(nd);
        sum = rebalance(in,out,sum,x);
        return sum;
    }
    long dec(int v, HashMap<Integer,Node> map, TreeSet<Node> in, TreeSet<Node> out, long sum, int x){
        Node nd=map.get(v);
        if(nd.in){ in.remove(nd); sum-= (long)nd.freq*nd.val; }
        else out.remove(nd);
        nd.freq--;
        if(nd.freq==0){ map.remove(v); nd.in=false; }
        else{ nd.in=false; out.add(nd); }
        sum = rebalance(in,out,sum,x);
        return sum;
    }
    long rebalance(TreeSet<Node> in, TreeSet<Node> out, long sum, int x){
        while(in.size()<x && !out.isEmpty()){
            Node t=out.pollFirst();
            t.in=true;
            in.add(t);
            sum+= (long)t.freq*t.val;
        }
        while(in.size()>x){
            Node t=in.pollLast();
            t.in=false;
            out.add(t);
            sum-= (long)t.freq*t.val;
        }
        while(!in.isEmpty() && !out.isEmpty()){
            Node best=out.first(), worst=in.last();
            if(CMP.compare(best,worst)<0){
                out.pollFirst(); in.pollLast();
                worst.in=false; out.add(worst); sum-= (long)worst.freq*worst.val;
                best.in=true; in.add(best); sum+= (long)best.freq*best.val;
            }else break;
        }
        return sum;
    }
}
