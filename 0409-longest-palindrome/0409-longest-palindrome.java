class Solution {
    public int longestPalindrome(String s) {
       int[] count = new int['z' - 'A' + 1];
		for (char c : s.toCharArray()) 
            count[c - 'A']++;
		int odd = 0;
		for (char c = 'A'; c <= 'z'; c++) 
            odd += (count[c - 'A'] & 1);
		return s.length() - odd + (odd > 0 ? 1 : 0); 
    }
}