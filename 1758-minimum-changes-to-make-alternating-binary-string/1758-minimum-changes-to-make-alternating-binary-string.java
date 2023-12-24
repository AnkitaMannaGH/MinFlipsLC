class Solution {
    public int minOperations(String s) {
        char a[] = s.toCharArray();
        for(int i = 0; i < a.length; i += 2) {
            if(a[i] == '1') a[i] = '0';
            else a[i] = '1';
        }
        int count_zeros = 0, count_ones = 0;
        for(char c : a) {
            if(c == '1') count_ones++;
            else count_zeros++;
        }
        return Math.min(count_zeros, count_ones);
    }
}