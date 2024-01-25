class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int[] memo = new int[t2.length() + 1];
        char[] t1c = t1.toCharArray(), t2c = t2.toCharArray();
        for (int i = t1c.length - 1; i > -1; i--) {
            int previousRigth = 0, newRight = 0;
            for (int j = t2c.length - 1; j > -1; j--) {
                int tmp = memo[j];
                int max;
                if (t1c[i] == t2c[j]) max = previousRigth + 1;
                else max = Math.max(tmp, newRight);
                memo[j] = newRight = max;
                previousRigth = tmp;
            }
        }
        return memo[0];
    }
}