class Solution {
    public int scoreOfString(String s) {
        int val=0;
        for(int i=0;i<s.length()-1;i++)
        {
            char c=s.charAt(i);
            char d=s.charAt(i+1);
            val=val+Math.abs(c-d);
        }
        return val;
    }
}