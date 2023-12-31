class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (pos[c] == -1) {
                pos[c] = i;
            }
            else {
                res = Math.max(res, i - pos[c] - 1);
            }
        }
        return res; 
    }
}