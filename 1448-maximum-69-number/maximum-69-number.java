class Solution {
    public int maximum69Number (int num) {
        int x=num,p=-1,i=0;
        while(x>0){
            if(x%10==6) p=i;
            x/=10;
            i++;
        }
        if(p<0) return num;
        int pow=1;
        while(p-->0) pow*=10;
        return num+3*pow;
    }
}
