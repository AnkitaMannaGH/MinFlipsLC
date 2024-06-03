class Solution {
    public int appendCharacters(String s, String t) {
       int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            int idx = s.indexOf(t.charAt(j), i);
            if (idx < 0) return t.length() - j;
            i = idx + 1;
            j++;
        }
        return t.length() - j; 
    }
}