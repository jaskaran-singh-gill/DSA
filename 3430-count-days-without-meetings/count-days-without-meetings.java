import java.util.*;
class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        long covered=0;
        int i=0,n=meetings.length;
        while(i<n){
            int l=meetings[i][0], r=meetings[i][1];
            int j=i+1;
            while(j<n && meetings[j][0]<=r+1){
                if(meetings[j][1]>r) r=meetings[j][1];
                j++;
            }
            covered+=r-(long)l+1;
            i=j;
        }
        long res=days - covered;
        return res<=0?0:(int)res;
    }
}
