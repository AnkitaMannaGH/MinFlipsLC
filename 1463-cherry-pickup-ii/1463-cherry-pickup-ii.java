class Solution {
    private static int[][] DIRS = {{-1, -1}, {-1, 0}, {-1, 1}};
    
    public int cherryPickup(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[n][n];
        int ans = 0;
        
        for (int i = 0; i < m; i++) {
            int[][] nextDP = new int[n][n];
            for (int j = 0; j <= i && j < n; j++) {
                for (int k = n - 1; k >= n - i - 1 && k >= 0; k--) {
                    for (int[] dir1 : DIRS) {
                        int prevJ = j + dir1[1];
                        for (int[] dir2 : DIRS) {
                            int prevK = k + dir2[1];
                            if (prevJ >= 0 && prevJ < n && prevK >= 0 && prevK < n) {
                                nextDP[j][k] = Math.max(nextDP[j][k], dp[prevJ][prevK]);
                            }
                        }
                    }
                    if (j == k) {
                        nextDP[j][k] += grid[i][j];
                    } else {
                        nextDP[j][k] += grid[i][j] + grid[i][k];
                    }
                    if (i == m - 1) {
                        ans = Math.max(ans, nextDP[j][k]);
                    }                    
                }
            }
            dp = nextDP;
        }
        return ans;
    }
}