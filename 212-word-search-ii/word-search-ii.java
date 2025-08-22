import java.util.*;
class Solution {
    static class Node { Node[] next = new Node[26]; String w; }
    char[][] b;
    int R,C,left;
    Node root=new Node();
    List<String> out;
    public List<String> findWords(char[][] board, String[] words) {
        b=board; R=b.length; C=b[0].length;
        int[] cnt=new int[26]; boolean[] pres=new boolean[26];
        for(int i=0;i<R;i++) for(int j=0;j<C;j++){int k=b[i][j]-'a'; cnt[k]++; pres[k]=true;}
        int[] tmp=new int[26];
        int valid=0;
        for(String s:words){
            char[] cs=s.toCharArray();
            if(!pres[cs[0]-'a']) continue;
            boolean ok=true; int mask=0;
            for(char ch:cs){int k=ch-'a'; int v=tmp[k]+1; tmp[k]=v; if(v>cnt[k]){ok=false;break;} mask|=1<<k;}
            while(mask!=0){int t=mask&-mask; int k=Integer.numberOfTrailingZeros(t); tmp[k]=0; mask-=t;}
            if(!ok) continue;
            Node cur=root;
            for(char ch:cs){int k=ch-'a'; Node nx=cur.next[k]; if(nx==null){nx=new Node(); cur.next[k]=nx;} cur=nx;}
            if(cur.w==null){cur.w=s; valid++;}
        }
        out=new ArrayList<>(valid);
        left=valid;
        if(left==0) return out;
        for(int i=0;i<R&&left>0;i++){
            for(int j=0;j<C&&left>0;j++){
                if(root.next[b[i][j]-'a']!=null) dfs(i,j,root);
            }
        }
        return out;
    }
    void dfs(int i,int j,Node p){
        if(left==0) return;
        char ch=b[i][j];
        int idx=ch-'a';
        Node u=p.next[idx];
        if(u==null) return;
        if(u.w!=null){out.add(u.w); u.w=null; left--;}
        b[i][j]='#';
        if(i>0&&b[i-1][j]!='#') dfs(i-1,j,u);
        if(j>0&&b[i][j-1]!='#') dfs(i,j-1,u);
        if(i+1<R&&b[i+1][j]!='#') dfs(i+1,j,u);
        if(j+1<C&&b[i][j+1]!='#') dfs(i,j+1,u);
        b[i][j]=ch;
        if(u.w==null){
            for(int k=0;k<26;k++) if(u.next[k]!=null) return;
            p.next[idx]=null;
        }
    }
}
