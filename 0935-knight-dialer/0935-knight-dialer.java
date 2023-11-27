class Solution {
     
    private final int mod = 1000000007;
    
    public int knightDialer(int N) {
        String[] board = {"46", "68", "79", "48", "039", "", "017", "26", "13", "24"};
        int[][] dp = new int[10][N];
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            res += dfs(i, N-1, dp, board);
            res %= mod;
        }
        return res % mod;
    }
    
    private int dfs(int curr, int N, int[][] dp, String[] board) {
        if (N == 0) return 1;
        if (dp[curr][N] != 0) return dp[curr][N];
        int ans = 0;
        for (char c : board[curr].toCharArray()) {
            int next = c - '0';
            ans += dfs(next, N-1, dp, board);
            ans %= mod;
        }
        dp[curr][N] = ans;
        return ans;
    }
}