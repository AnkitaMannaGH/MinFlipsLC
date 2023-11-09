class Solution {
    public int countHomogenous(String s) {
      long res = 0, cnt = 0, mod = (int) 1e9 + 7;
        for(int i = 0; i < s.length(); i++) {
            cnt = (i > 0 && s.charAt(i) == s.charAt(i - 1)) ? cnt + 1 : 1;
            res += cnt;
        }
        return (int) (res % mod);  
    }
}