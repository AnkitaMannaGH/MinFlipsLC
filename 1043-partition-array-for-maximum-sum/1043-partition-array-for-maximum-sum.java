class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length, dp[] = new int[n + 1];  //dp[i] max sum of first i ele, 0 ... A[i -1];
        for (int i = 1; i < dp.length; i++) {  // dp[0] = 0;
            for (int j = 0, max = 0; i - j - 1 >= 0 && j < K; j++) {
                max = Math.max(max, A[i - j - 1]);  // subarray from i - j - 1, i - 1;
                dp[i] = Math.max(dp[i], max * (j + 1) + dp[i - j - 2 + 1]);
            }
        }
        return dp[n];
    }
}