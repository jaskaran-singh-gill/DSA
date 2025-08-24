class Solution {
    int R,C,L;
    char[][] b;
    char[] w;
    public boolean exist(char[][] board, String word) {
        b=board; R=b.length; C=b[0].length; L=word.length();
        if (L==0) return true;
        if (L>R*C) return false;
        int[] cnt=new int[128];
        for(int i=0;i<R;i++) for(int j=0;j<C;j++) cnt[b[i][j]]++;
        char[] tmp=word.toCharArray();
        for(char c:tmp){ if(--cnt[c]<0) return false; }
        if (cnt[tmp[0]] < cnt[tmp[L-1]]) {
            for(int i=0,j=L-1;i<j;i++,j--){ char t=tmp[i]; tmp[i]=tmp[j]; tmp[j]=t; }
        }
        w=tmp;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(b[i][j]==w[0] && dfs(i,j,0)) return true;
            }
        }
        return false;
    }
    boolean dfs(int i,int j,int k){
        if(k==L-1) return true;
        char ch=b[i][j];
        b[i][j]^=1024;
        int nk=k+1;
        if(i>0 && b[i-1][j]==w[nk] && dfs(i-1,j,nk)) { b[i][j]^=1024; return true; }
        if(j>0 && b[i][j-1]==w[nk] && dfs(i,j-1,nk)) { b[i][j]^=1024; return true; }
        if(i+1<R && b[i+1][j]==w[nk] && dfs(i+1,j,nk)) { b[i][j]^=1024; return true; }
        if(j+1<C && b[i][j+1]==w[nk] && dfs(i,j+1,nk)) { b[i][j]^=1024; return true; }
        b[i][j]^=1024;
        return false;
    }
}
