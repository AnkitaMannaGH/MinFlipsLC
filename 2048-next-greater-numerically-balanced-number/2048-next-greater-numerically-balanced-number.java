class Solution {
     public int nextBeautifulNumber(int n) {
        for(int i=n+1;;i++)
            if(isNumericallyBalanced(i)) return i;
    }
    private boolean isNumericallyBalanced(int n) {
        int[] count = new int[10];
        for(;n>0;n/=10)
            if(++count[n%10] > n%10) return false;
        for(int i=1;i<10;i++) 
            if(count[i] != 0 && count[i] != i) return false;
        return true;
    }
}