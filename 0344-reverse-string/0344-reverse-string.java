class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;        
        reverse(s, start , end);
    }
    static char [] reverse(char [] s, int start , int end){
        while(start <= end){
            swap (s, start, end );
            start ++;
            end --;
        }
        return s;
    }
    static void swap(char [] s, int a, int b){
        char temp = s[a];
        s[a]  = s[b];
        s[b]  = temp;
    }
}